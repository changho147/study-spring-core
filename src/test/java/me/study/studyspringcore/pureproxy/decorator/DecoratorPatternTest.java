package me.study.studyspringcore.pureproxy.decorator;

import me.study.studyspringcore.pureproxy.decorator.code.*;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    public void noDecorator() throws Exception {
        RealComponent realComponent = new RealComponent();

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(realComponent);

        decoratorPatternClient.execute();
    }

    @Test
    public void decorator1() throws Exception {
        Component realComponent = new RealComponent();

        MessageDecorator messageDecorator = new MessageDecorator(realComponent);

        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecorator);

        decoratorPatternClient.execute();
    }

    @Test
    public void decorator2() throws Exception {
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(timeDecorator);

        decoratorPatternClient.execute();
    }
}
