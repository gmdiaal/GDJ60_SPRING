package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/product/*") //	s1(root)/product/...
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping (value = "list")
	public String getProductList() throws Exception {
		System.out.println("Product List");
		
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size()>0);
		
		return "/product/productList";
	}
	
	@RequestMapping (value = "detail")		// prefix + url 경로 + suffix
	public String getProductDetail() {
		System.out.println("Product Detail");
		return "/product/productDetail";	//jsp 경로
	}
	
	@RequestMapping (value = "productAdd") //url경로와 jsp 경로가 일치할 시 void로 해도 댐.
	public void productAdd (  ) {
		
	}
	
	@RequestMapping (value = "update")
	public ModelAndView update () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/update");	//url을 봐 web-inf 필요없음.
		return mv;
	}
	
}
