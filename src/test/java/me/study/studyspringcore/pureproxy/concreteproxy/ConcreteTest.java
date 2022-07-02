package me.study.studyspringcore.pureproxy.concreteproxy;

import me.study.studyspringcore.pureproxy.concreteproxy.code.ConcreteClient;
import me.study.studyspringcore.pureproxy.concreteproxy.code.ConcreteLogic;
import me.study.studyspringcore.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteTest {

    @Test
    public void noProxy() throws Exception {
        ConcreteClient concreteClient = new ConcreteClient(new ConcreteLogic());

        concreteClient.execute();
    }

    @Test
    public void addProxy() throws Exception {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);

        ConcreteClient concreteClient = new ConcreteClient(timeProxy);

        concreteClient.execute();
    }
}
