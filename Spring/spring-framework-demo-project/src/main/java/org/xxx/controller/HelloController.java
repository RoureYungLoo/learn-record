package org.xxx.controller;


import com.sun.javaws.exceptions.ExitException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private final String flag = "";
    private Integer times = 0;
//    private AtomicInteger times = new AtomicInteger(0);

    private final Lock lock = new ReentrantLock();

    @GetMapping("/add")
    @ResponseBody
    public void add() {
//        synchronized (flag){
//            times++;
//        }
        // this.times++;

        lock.lock();
        try {
            times++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        System.out.println("add, cur time: " + this.times);
//        System.out.println("add, cur time: "+times.incrementAndGet());


    }


    @GetMapping("/sub")
    @ResponseBody
    public void sub() {
//        synchronized (flag){
//            times--;
//        }
//        this.times--;

        lock.lock();
        try {
            times--;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("sub, cur time: " + this.times);
//        System.out.println("sub, cur time: "+times.decrementAndGet());

    }

    @GetMapping("/reset")
    @ResponseBody
    public void reset() {
        this.times = 0;
        System.out.println("reset, cur time: " + this.times);

//        times.set(0);
//        System.out.println("reset, cur time: "+times.get());


    }

    @GetMapping
    public String hello(Model mv) {
        mv.addAttribute("times", this.times);
        return "index";
    }

    @ResponseBody
    @GetMapping("/get")
    public Integer getValue() {
//        return this.times.get();
        return this.times;
    }
}
