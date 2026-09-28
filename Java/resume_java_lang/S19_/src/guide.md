## Platform Threads vs Virtual Threads

|                              | `Thread.ofPlatform()`     | `Thread.ofVirtual()`   |
|------------------------------|---------------------------|------------------------|
| Type                         | Traditional thread        | Virtual thread         |
| Management                   | JVM + OS                  | Primarily JVM          |
| Cost per thread              | Higher                    | Much lower             |
| Practical quantity           | Relatively limited        | Can be very large      |
| Good for I/O                 | Yes, but scales less well | **Excellent**          |
| Good for CPU-intensive tasks | Yes                       | No magical parallelism |
| Creating thousands           | Generally poor            | Expected use case      |

### How Virtual Threads are executed

Virtual Threads are managed by the JVM and scheduled to run on **Carrier Threads**, which are Platform Threads used internally by the Virtual Thread scheduler.

```text
Virtual Threads

VT1 ─────┐
VT2 ─────┤
VT3 ─────┤
VT4 ─────┼──► JVM Scheduler
VT5 ─────┤          │
VT6 ─────┘          │
                    ▼
              Carrier Threads
              ┌─────────────┐
              │ Platform T1 │
              │ Platform T2 │
              │ Platform T3 │
              │ Platform T4 │
              └─────────────┘
                    │
                    ▼
                   CPU
```

The JVM is responsible for creating and managing the **Carrier Threads**. It is not necessary to manually create Platform Threads or put them into a `WAITING` state.

A Virtual Thread is mounted onto a Carrier Thread when it needs to execute:

```text
Virtual Thread
      │
      │ mount
      ▼
Carrier Thread
      │
      ▼
     CPU
```

When the Virtual Thread performs a supported blocking operation, the JVM can suspend it and release the Carrier Thread to execute another Virtual Thread:

```text
VT1 ──► waiting for I/O
              │
              │ Carrier becomes available
              ▼
VT2 ──► Carrier Thread ──► CPU
```

Later, when `VT1` is ready to continue, it can be mounted again on an available Carrier Thread:

```text
VT1 ──► JVM Scheduler ──► Carrier Thread ──► CPU
```

The Carrier Thread used after resuming does **not necessarily need to be the same Carrier Thread** that executed the Virtual Thread previously.

### Mental Model

```text
Application
    │
    │ creates
    ▼
Virtual Threads
    │
    ▼
JVM Scheduler
    │
    │ schedules
    ▼
Carrier Threads
(Platform Threads)
    │
    ▼
Operating System
    │
    ▼
CPU
```

> **Key concept:** Many Virtual Threads can 
> be multiplexed over a much smaller number 
> of Platform Threads. Virtual Threads do not 
> create additional CPU parallelism; they make
> concurrent blocking workloads much cheaper to represent.