package S04_;

/*
related to MANIFEST.MF do JAR.
Example:

Manifest-Version: 1.0
Implementation-Title: Metrics Core
Implementation-Version: 2.4
Implementation-Vendor: devznagl
Specification-Title: Metrics API
Specification-Version: 1.0

So if your application is running from a JAR properly packed, you could obtain:

Package p = MyClass.class.getPackage();

System.out.println(p.getImplementationTitle());
// Metrics Core
System.out.println(p.getImplementationVersion());
// 2.4
System.out.println(p.getSpecificationVersion());
// 1.0

Invisível na IDE, retonnará null:


If you're using Maven there's a practical way to set MANIFEST.MF during the package.

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.4.2</version>
            <configuration>
                <archive>
                    <manifestEntries>
                        <Implementation-Title>Metrics Core</Implementation-Title>
                        <Implementation-Version>2.4</Implementation-Version>
                        <Implementation-Vendor>devznagl</Implementation-Vendor>
                        <Specification-Title>Metrics API</Specification-Title>
                        <Specification-Version>1.0</Specification-Version>
                    </manifestEntries>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>



*/

