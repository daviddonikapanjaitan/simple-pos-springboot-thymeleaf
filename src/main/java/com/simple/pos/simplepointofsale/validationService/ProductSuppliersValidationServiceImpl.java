package com.simple.pos.simplepointofsale.validationService;

import com.simple.pos.simplepointofsale.Dto.ProductSuppliersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ProductSuppliersValidationServiceImpl implements ProductSuppliersValidationService{

    @Autowired
    ValidationUtilsService validationUtilsService;

    @Override
    public boolean productSuppliersValidation(
        ProductSuppliersDto productSuppliersDto,
        RedirectAttributes redirectAttributes
    ) {
        boolean resultReturn = true;

        if(
            productSuppliersDto.getProductId() == null ||
            productSuppliersDto.getSupplierCode() == null ||
            productSuppliersDto.getValueSuppliedToDate() == null ||
            productSuppliersDto.getTotalQuantitySuppliedToDate() == null ||
            productSuppliersDto.getFirstItemSuppliedDate() == null ||
            productSuppliersDto.getLastItemSuppliedDate() == null ||
            productSuppliersDto.getDeliveryLeadTime() == null ||
            productSuppliersDto.getStandardPrice() == null ||
            productSuppliersDto.getPercentageDiscount() == null ||
            productSuppliersDto.getMinimumOrderQuantity() == null ||
            productSuppliersDto.getMaximumOrderQuantity() == null ||
            productSuppliersDto.getOtherItemSuppliersDetails() == null ||
            productSuppliersDto.getProductId().equalsIgnoreCase("") ||
            productSuppliersDto.getSupplierCode().equalsIgnoreCase("") ||
            productSuppliersDto.getValueSuppliedToDate().equalsIgnoreCase("") ||
            productSuppliersDto.getTotalQuantitySuppliedToDate().equalsIgnoreCase("") ||
            productSuppliersDto.getFirstItemSuppliedDate().equalsIgnoreCase("") ||
            productSuppliersDto.getLastItemSuppliedDate().equalsIgnoreCase("") ||
            productSuppliersDto.getDeliveryLeadTime().equalsIgnoreCase("") ||
            productSuppliersDto.getStandardPrice().equalsIgnoreCase("") ||
            productSuppliersDto.getPercentageDiscount().equalsIgnoreCase("") ||
            productSuppliersDto.getMinimumOrderQuantity().equalsIgnoreCase("") ||
            productSuppliersDto.getMaximumOrderQuantity().equalsIgnoreCase("") ||
            productSuppliersDto.getOtherItemSuppliersDetails().equalsIgnoreCase("")
        ){
            redirectAttributes.addFlashAttribute("message", "Field Must be contains");
        }
        
        // else if(
        //     productSuppliersDto.getProductId().length() < 5
        // ){
        //     redirectAttributes.addFlashAttribute("message", "Field product id length must larger than 5");
        // }

        else if(
            !validationUtilsService.checkProductId(productSuppliersDto.getProductId())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Product Id");
        }


        // else if(
        //     productSuppliersDto.getSupplierCode().length() < 5
        // ){
        //     redirectAttributes.addFlashAttribute("message", "Field Supplier Code length must larger than 5");
        // }

        else if(
            !validationUtilsService.checkSupplierCode(productSuppliersDto.getSupplierCode())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Supplier Code");
        }
        
        else if(
            !validationUtilsService.phoneValidation(productSuppliersDto.getValueSuppliedToDate())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Valued Suppled to date");
        }else if(
            !validationUtilsService.phoneValidation(productSuppliersDto.getTotalQuantitySuppliedToDate())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Valued Suppled to date");
        }else if(
            !validationUtilsService.phoneValidation(productSuppliersDto.getStandardPrice())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Standard Price");
        }else if(
            !validationUtilsService.phoneValidation(productSuppliersDto.getPercentageDiscount())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Percentage Discount");
        }else if(
            !validationUtilsService.phoneValidation(productSuppliersDto.getMinimumOrderQuantity())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Minimum Order Quantity");
        }else if(
            !validationUtilsService.phoneValidation(productSuppliersDto.getMaximumOrderQuantity())
        ){
            redirectAttributes.addFlashAttribute("message", "Invalid Maximum Order Quantity");
        }
        // else if(
        //     !validationUtilsService.phoneValidation(productSuppliersDto.getOtherItemSuppliersDetails())
        // ){
        //     redirectAttributes.addFlashAttribute("message", "Invalid Other Item Suppliers Details");
        // }
        else if(
            productSuppliersDto.getDeliveryLeadTime().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field delivery lead time length must larger than 5");
        }else if(
            productSuppliersDto.getStandardPrice().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field standard price length must larger than 5");
        }else if(
            Long.parseLong(productSuppliersDto.getPercentageDiscount()) < 0 && 
            Long.parseLong(productSuppliersDto.getPercentageDiscount()) > 100
        ){
            redirectAttributes.addFlashAttribute("message", "Field percentage discount range 0-100%");
        }
        // else if(
        //     productSuppliersDto.getMinimumOrderQuantity().length() < 5
        // ){
        //     redirectAttributes.addFlashAttribute("message", "Field minimum order quantity length must larger than 5");
        // }else if(
        //     productSuppliersDto.getMaximumOrderQuantity().length() < 5
        // ){
        //     redirectAttributes.addFlashAttribute("message", "Field maximum order quantity length must larger than 5");
        // }
        else if(
            productSuppliersDto.getOtherItemSuppliersDetails().length() < 5
        ){
            redirectAttributes.addFlashAttribute("message", "Field other item suppliers details length must larger than 5");
        }else{
            resultReturn = false;
        }

        return resultReturn;
    }
}
