package com.hh.springboot.state;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

/**
 * @author HaoHao
 * @date 2020/11/19 5:18 下午
 */
@Slf4j
@Component
public class Listener {

    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void transition(Transition<States, Events> transition) {
                if (transition.getTarget().getId() == States.UNPAID) {
                    log.info("订单创建，待支付");
                    return;
                }

                if (transition.getSource().getId() == States.UNPAID
                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
                    log.info("用户完成支付，待收货");
                    return;
                }

                if (transition.getSource().getId() == States.WAITING_FOR_RECEIVE
                        && transition.getTarget().getId() == States.DONE) {
                    log.info("用户已收货，订单完成");
                }
            }

        };
    }
}
