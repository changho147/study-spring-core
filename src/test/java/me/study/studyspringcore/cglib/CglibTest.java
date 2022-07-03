package me.study.studyspringcore.cglib;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.cglib.code.TimeMethodInterceptor;
import me.study.studyspringcore.common.service.ConcreteService;
import me.study.studyspringcore.common.service.ServiceImpl;
import me.study.studyspringcore.common.service.ServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {
    @Test
    public void cglib() throws Exception {
        ConcreteService target = new ConcreteService();
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        proxy.call();
    }

    @Test
    public void cglibForInterface() throws Exception {
        ServiceInterface target = new ServiceImpl();
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ServiceInterface proxy = (ServiceInterface) enhancer.create();

        proxy.save();
        proxy.find();
    }
}
