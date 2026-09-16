void main() throws InterruptedException {

    //Low level coordination by object monitor.
    // notify(). JVM choose one of the Threads which is waiting
    // notifyAll(). same thing, associate to the  synchronized object (queue in this case)

    Queue<String> queue = new LinkedList<>();
    Stack<String> stack = new Stack<>();

    Thread queueconsumer = new Thread(
            () -> {
                long start = System.nanoTime();

                synchronized (queue) {
                    while (queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    while (!queue.isEmpty()){
                        var item = queue.poll();
                        System.out.println("Queue-consumer Consumed: " + item);
                    }
                }

                long end = System.nanoTime();

                System.out.println("Queue-consumer took " + (end - start) / 1_000_000.0 + " ms");
            }
    );

    Thread stackconsumer = new Thread(
            () -> {
                long start = System.nanoTime();

                synchronized (stack) {
                    while (stack.isEmpty()){
                        try {
                            stack.wait();
                        }catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    while (!stack.isEmpty()){
                        var item = stack.pop();
                        System.out.println("Stack-consumer Consumed: " + item);
                    }
                }

                long end = System.nanoTime();
                System.out.println("Stack-consumer took " + (end - start) / 1_000_000.0 + " ms" );
            }
    );

    Thread producer = new Thread(
            () -> {
                long start = System.nanoTime();

                synchronized (queue) {
                    queue.add("Motorcicle");
                    queue.add("Jeep");
                    queue.add("Truck");
                    // Send an alert to all the other Threads monitoring this synchronized object
                    queue.notifyAll();
                };
                synchronized (stack){
                    stack.push("Rhino");
                    stack.push("Seahorse");
                    stack.push("Bat");
                    // Send an alert to all the other Threads monitoring this synchronized object
                    stack.notifyAll();
                };

                long end = System.nanoTime();
                System.out.println("Producer took " + (end - start) / 1_000_000.0 + " ms" );
            }
    );

    queueconsumer.start();
    stackconsumer.start();
    Thread.sleep(1000);
    producer.start();

    //Pauses main Thread untill the subthreads are completed
    queueconsumer.join();
    stackconsumer.join();
    producer.join();

}