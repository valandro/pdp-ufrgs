## Explicação

### Tranca

Tranca é um mecanismo de sincronização que permite que uma, ou mais threads mães,
aguarde que outra thread termine sua execução.


### Como funciona?

Através da Classe **CountDownLatch** inicializa a processo através do seu construtor, recebendo
um **int** que corresponde ao número de threads que se deseja aguardar. 

```java
CountDownLatch latch = new CountDownLatch(3);
```

Após a criação da tranca, deve-se executar as **N threads** que se deseja aguardar, e 
**imediatamente** após a chamada das threads, deve-se chamar:

```java
latch.await();
```

A execução do código irá parar no **latch.await()** e irá aguardar até que todas as threads filhas
executem e notifiquem a thread mãe com:

```java
latch.countDown();
```

Essa função decrementa o contador e quando ele atinge **zero**, o fluxo de 
execução volta para a thread mãe.
