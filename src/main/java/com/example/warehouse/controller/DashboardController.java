package com.example.warehouse.controller;

import com.example.warehouse.dto.ExpiredPeriodDto;
import com.example.warehouse.repository.InputProductRepository;
import com.example.warehouse.repository.OutputProductRepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.service.AuthService;
import com.example.warehouse.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    final NotificationService notificationService;
    final ProductRepository productRepository;
    final InputProductRepository inputProductRepository;
    final OutputProductRepository outputProductRepository;
    final AuthService authService;

    @GetMapping(path = "/most-sold")
    public String getMostSold(Model model, HttpServletRequest req, HttpServletResponse res){
        if (authService.deleteTokenIf(req, res)) {
            return "secured-page";
        }

        String periods="week, month, year";
        LocalDate from = LocalDate.now();
        LocalDate to = LocalDate.now();
        String limit = req.getParameter("limit");
        if(req.getParameter("period")==null
                || req.getParameter("period").equals("today")
                || !periods.contains(req.getParameter("period"))){
            from=LocalDate.now().minusDays(1);
        }else{
            switch (req.getParameter("period")){
                case "week"->{
                    from=LocalDate.now().minusWeeks(1);
                }
                case "month"->{
                    from=LocalDate.now().minusMonths(1);
                }
                case "year"->{
                    from=from.minusYears(1);
                }
            }
        }

        if(limit==null){
            model.addAttribute("outputProductList",
                    outputProductRepository.getOutputProductWithLimit(from, to, 5));
        }else{
            if(Integer.parseInt(limit)>0){
                model.addAttribute("outputProductList",
                        outputProductRepository.getOutputProductWithLimit(from, to, Integer.parseInt(limit)));
            }else {
                model.addAttribute("outputProductList",
                        outputProductRepository.getOutputProductWithLimit(from, to, 5));
            }

        }

        model.addAttribute("from", from);
        model.addAttribute("to", to);

        return "dashboard/most_sold";
    }
    @GetMapping(path = "/notifications")
    public String getNotificationPage(Model model, HttpServletRequest req, HttpServletResponse res){
        if (authService.deleteTokenIf(req, res)){return "secured-page";}
        model.addAttribute("notifications_count",notificationService.getNotificationsCount());
        model.addAttribute("expire_date",notificationService.getExpire_period());
        model.addAttribute("products",
                inputProductRepository.findAllByInput_ActiveTrueAndExpireDateBeforeAndAmountNot(
                        LocalDate.now().plusDays(notificationService.getExpire_period()), 0D));
        return "dashboard/notifications";
    }

    @SneakyThrows
    @PostMapping("/expire_date")
    public String changeExpire(@ModelAttribute ExpiredPeriodDto period, HttpServletResponse res, HttpServletRequest req){
        if (authService.deleteTokenIf(req, res)){return "secured-page";}
        notificationService.setExpire_period(period.getPeriod());
        return "redirect:/dashboard/notifications";
    }
}
