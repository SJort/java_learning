# Functional interfaces
Een interface met maar 1 abstract method.
Kun je doorgeven alsof het een variable is:  
`print(animals, animal -> animal.isCanHop());`  
Dit is deferred execution: de code wordt pas later uitgevoerd.
Lambdas kunnen meerdere parameters hebben.
Als je `{}` gebruikt, moet je in de body ook een return en semicolon hebben.
`@FunctionalInterface` een notatie om aan te geven dat dit een functional interface blijft, puur voor developers.

Lambda mag altijd instance en class variables gebruiken.
Method parameters en local variables alleen als ze (effectively) final zijn.

Sommige functional interfaces kun je combineren:
voor consumer: x.andThen(y);
voor predicate: x.and(y);
De Optional class heeft ook truukjes:
je kunt bijvoorbeeld optional.ifPresent(consumerX) doen 
of orElseThrow, of orElseCall

# Streams
Source data / stream
Intermediate operations: convert the input stream to output stream
Terminal operation: the final operation where the stream is converted to data.
Streams are lazy: when terminal operation is called, only then the intermediate operatations are ran
Stream have count options, only do the first two.
Parallel streams: have multiple workers on intermediate operations: list.paralelelStream()
Order is destroyed, and not faster for small streams.