package me.kktrkkt.springboot.mvc.hateoas;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Aspect
public class HateoasAspect {

    @Around("@annotation(Hateoas)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        RepresentationModel<?> result = (RepresentationModel<?>) joinPoint.proceed();
        result.add(linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());
        return result;
    }

}
