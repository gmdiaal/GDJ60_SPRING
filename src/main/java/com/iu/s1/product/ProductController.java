package com.iu.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/product/*") //	s1(root)/product/...
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping (value = "list1")
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		System.out.println("Product List");
		
		//ModelAndView mv = new ModelAndView();
		
		//for(int n:num) {System.out.println(n);}
		
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size()>0);
		
		mv.setViewName("./product/productList");
		mv.addObject("list", ar);
		//return "/product/productList";
		return mv;
	}
	
	@RequestMapping (value = "detail")		// prefix + url 경로 + suffix
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		//parameter이름이 dto의 setter의 이름과 같아야댐 (setProductDTO의 productDTO) 또한 @Autowired도 같음.
		
		System.out.println("Product Detail");
		//String num = request.getParameter("num"); //다 String으로 옴.

//		System.out.println(name);
//		System.out.println(age);
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProduct_num(num);
		productDTO = productService.getProductDetail(productDTO); 
		//dto를 반환하는데 productService.getProductDetail(productDTO); 이렇게 써서 그래도 11000L이 나왓음
		model.addAttribute("dto", productDTO);
		
		System.out.println(productDTO != null);

		
		return "product/productDetail";	//web에 리턴하는 jsp 경로
	}
	
	@RequestMapping (value = "productAdd", method = RequestMethod.GET) //url경로와 jsp 경로가 일치할 시 void로 해도 댐.
	public void productAdd (  ) {
		
	}
	
	@RequestMapping (value = "productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO dto) throws Exception {
		int result = productService.setAddProduct(dto, null);
		System.out.println(result==1);
		return "redirect:./list";
	}
	
	@RequestMapping (value = "update")
	public ModelAndView update () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");	//context.xml이 /WEB-INF/views/, .jsp 생략해줌
		return mv;
	}
	
}
