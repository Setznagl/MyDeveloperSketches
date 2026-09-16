module S04_ {

    requires java.sql;

    // Enable runtime reflection
    opens src;

    // Shares only the necessary
    exports src;

    // to - delegate the target, more granularity
    // uses - define a service to be consumed
    // provides xxxxx with - define a service with an implementation

}