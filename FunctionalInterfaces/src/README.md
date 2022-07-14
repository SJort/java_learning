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