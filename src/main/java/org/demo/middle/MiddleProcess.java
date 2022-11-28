package org.demo.middle;

import org.demo.middle.loadbalance.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MiddleProcess {
    @Autowired
    LoadBalance loadBalance;

    private void addRequest(int page){
        return;
    }
}
