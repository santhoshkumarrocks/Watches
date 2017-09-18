package com.santhoshproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.santhoshproject.dao.CartDAO;
import com.santhoshproject.dao.Registerdao;
import com.santhoshproject.dao.categorydao;
import com.santhoshproject.dao.productdao;
import com.santhoshproject.dao.supplierdao;
import com.santhoshproject.model.Register;
import com.santhoshproject.model.cart;
import com.santhoshproject.model.category;
import com.santhoshproject.model.product;
import com.santhoshproject.model.supplier;

@Controller
public class HomeController {
	@Autowired
	Registerdao rd;
	@Autowired
	categorydao cd;
	@Autowired
	supplierdao sd;
	@Autowired
	productdao pd;
	@Autowired
	CartDAO c;
	

	@RequestMapping(value = {"/","/home"})
	String indexPage(HttpSession session) 
	{
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutusPage(HttpSession session) {
		return "aboutus";
	}

	@RequestMapping("/contactus")
	String contactusPage(HttpSession session) {
		return "contactus";
	}

	@RequestMapping("/signup")
	String signupPage(Model m) {
		m.addAttribute("regmodel", new Register());
		return "signup";
	}

	@RequestMapping("/getuser")
	String getuser(@Valid @ModelAttribute("regmodel") Register u, BindingResult br, Model m,HttpSession session) {

		if (br.hasErrors()) {
			m.addAttribute("regmodel", u);
			return "signup";

		} else {
			if (rd.insertuser(u))

				return "login";

			else {
				m.addAttribute("Register", u);
				return "signup";

			}
		}
	}

	@RequestMapping("/login")
	String loginPage(HttpSession session) {
		return "login";
	}

	@RequestMapping("/addcate")
	String addcate(Model m,HttpSession session) {
		m.addAttribute("category", new category());
		m.addAttribute("cg", cd.showall());
		m.addAttribute("check",true);
		return "addcate";
	}

	@RequestMapping("/getcategory")
	String getcategory(@Valid @ModelAttribute("category") category c, BindingResult br, Model m,HttpSession session) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			m.addAttribute("category", c);
			return "addcate";
		} else {
			if (cd.insertuser(c)) {
				return "redirect:/addcate";
			} else {
				System.out.println("error by dao");
				m.addAttribute("category", c);
				return "addcate";
			}
		}
	}
	@RequestMapping("/updcat")
	String updcat(@Valid @ModelAttribute("category") category c, BindingResult br, Model m,HttpSession session) {
		if (br.hasErrors()) 
		{
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			m.addAttribute("category", c);
			return "addcate";
		} else 
			{
			if (cd.updateuser(c)) 
			{
				return "redirect:/addcate";
			} else 
			{
				System.out.println("error by dao");
				m.addAttribute("category", c);
				return "addcate";
			}
		}
	}
			
		

	@RequestMapping("/addsupp")
	String addsupp(Model m,HttpSession session) {
		m.addAttribute("supplier", new supplier());
		m.addAttribute("cz", sd.showall());
		m.addAttribute("check",true);
		return "addsupp";
	}

	@RequestMapping("/getsupplier")
	String getsupplier(@Valid @ModelAttribute("supplier") supplier s, BindingResult br, Model m,HttpSession session) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			m.addAttribute("supplier", s);
			return "addsupp";
		} else {
			if (sd.insertuser(s)) {
				return "redirect:/addsupp";
			} else {
				System.out.println("error by dao");
				m.addAttribute("supplier", s);
				return "addsupp";
			}
		}
	}
	@RequestMapping("/updsupp")
	String updsuppr(@Valid @ModelAttribute("supplier") supplier s, BindingResult br, Model m,HttpSession session) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			m.addAttribute("supplier", s);
			return "addsupp";
		} else {
			if (sd.updateuser(s)) {
				return "redirect:/addsupp";
			} else {
				System.out.println("error by dao");
				m.addAttribute("supplier", s);
				return "addsupp";
			}
		}
	}

	@RequestMapping("/addpro")
	String addpro(Model m,HttpSession session) {
		m.addAttribute("product", new product());
		m.addAttribute("allproducts", pd.showall());
		m.addAttribute("check",true);
		return "addpro";
	}

	@RequestMapping("/getproduct")
	String getproduct(@Valid @ModelAttribute("product") product p, BindingResult br, Model m,HttpSession session)throws Exception {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			m.addAttribute("product", p);
			return "addpro";
		} else {
		System.out.println("ASJGFOGFGAGFEG"+p.getName());
			if (pd.insertuser(p)) {
				System.out.println("1");
				String filePath="E:\\70\\santhoshproject\\src\\main\\webapp\\resources\\productimages\\";
				filePath=filePath+String.valueOf(p.getId())+""+".jpg";
				MultipartFile imagefile=p.getProductimage();
				if(!imagefile.isEmpty())
				{
					byte[] imageBytes=imagefile.getBytes();
					FileOutputStream fileOutputStream=new FileOutputStream(new File(filePath));
					fileOutputStream.write(imageBytes);
					fileOutputStream.close();
					Thread.sleep(10000);
					System.out.println("uploaded");
				}
				else
				{
					System.out.println("not uploaded");
				}
				return "redirect:/addpro";
			} else {
				System.out.println("error by dao");
				m.addAttribute("product", p);
				return "addpro";
			}
		}
	}
	@RequestMapping("/updpro")
	String updpro(@Valid @ModelAttribute("product") product p, BindingResult br, Model m,HttpSession session) {
		if (br.hasErrors()) {
			System.out.println("error because of model");
			System.out.println(br.getAllErrors());
			m.addAttribute("product", p);
			return "addpro";
		} else {
			if (pd.updateuser(p)) {
				return "redirect:/addpro";
			} else {
				System.out.println("error by dao");
				m.addAttribute("product", p);
				return "addpro";
			}
		}
	}
	
	@RequestMapping("/delcat/{cid}")
	String delcat(@PathVariable("cid") int id,HttpSession session)
	{
		cd.deleteuser(id);
		return "redirect:/addcate";
	}

	@RequestMapping("/editcat")
	String editcat(@RequestParam("getcatid")int id,Model m,HttpSession session)
	{
		m.addAttribute("category",cd.showone(id));
		m.addAttribute("cg", cd.showall());
		m.addAttribute("check",false);
		return "addcate";
	}
	
	
	@RequestMapping("/delsupp/{sid}")
	String delsupp(@PathVariable("sid") int id,HttpSession session)
	{
		sd.deleteuser(id);
		return "redirect:/addsupp";
	}

	@RequestMapping("/editsupp")
	String editsupp(@RequestParam("getsuppid")int id,Model m,HttpSession session)
	{
		m.addAttribute("supplier",sd.showone(id));
		m.addAttribute("cz", sd.showall());
		m.addAttribute("check",false);
		return "addsupp";
	}
	
	
	@RequestMapping("/delpro/{pid}")
	String delpro(@PathVariable("pid") int id,HttpSession session)
	{
		pd.deleteuser(id);
		return "redirect:/addpro";
	}

	@RequestMapping("/editpro")
	String editpro(@RequestParam("getproid")int id,Model m,HttpSession session)
	{
		m.addAttribute("product",pd.showone(id));
		m.addAttribute("cv", pd.showall());
		m.addAttribute("check",false);
		return "addpro";
	}
	@RequestMapping(value={"/signin"},method=RequestMethod.GET)
	public String loginController(@RequestParam("mail") String email,@RequestParam("upass") String pass,HttpSession session)
	{
		System.out.println(email);
		System.out.println(pass);
		String userName=null,userRole=null;
		boolean regloggedin=false;
		List<Register> allUser=rd.showall();
		boolean userExist=false;
		for(Register reg:allUser)
		{
			if(reg.getEmail().equals(email)&&reg.getPassword().equals(pass))
			{
				userExist=true;
				userName=reg.getName();
				userRole=reg.getRole();
			}

		}		
		if(userExist)
		{
			System.out.println("Welcome Mr./Mrs. "+email);
			session.setAttribute("userName",userName);
			session.setAttribute("userRole",userRole);
			session.setAttribute("userin",regloggedin);
			return "index";
		}
		else
		{
			return "login";
		}
		}
			
		@RequestMapping("/logout")
		public String logout(HttpSession session)
		{
			session.invalidate();
			return "redirect:/";
		}
		@RequestMapping("/allpro")
		String allpropage(Model p,HttpSession session)
		{
			System.out.println(pd.showall());
			p.addAttribute("promodel",new product());
			p.addAttribute("protable",pd.showall());
			p.addAttribute("check",true);
			return "allpro";
			
		}
		
		@RequestMapping("/singlepro")
		public String sin(@RequestParam("id") int prodid,Model p,HttpSession session)
		{
			p.addAttribute("promodel",new product());
			p.addAttribute("ci" ,pd.showone(prodid));
			return "singlepro";
		}
		
		@RequestMapping(value={"/addtocart/{getprodid}"})
		public String insertProdttoCart(@PathVariable("getprodid") int ProdId,HttpSession session)
		{
			try
			{
				product single=pd.showone(ProdId);
					if(single.getId()==ProdId)
					{
						String username=(String) session.getAttribute("userName");
						System.out.println(username);
						List<cart> singleuser=(c.singleUserCart(username));
						for(cart c:singleuser)
						{
							System.out.println(c.getCartid()+"     "+c.getProductname());
						}
							
						List<cart> singleprodfromcart=c.singleprodfromcart(single.getName(),username);
						if(singleprodfromcart.isEmpty())
						{
							cart cart=new cart();
							cart.setCartid((String)session.getAttribute("userName"));
							cart.setProductid(single.getId());
							cart.setPrice((int)single.getPrice());
							cart.setQuantity(1);
							cart.setProductname(single.getName());
							cart.setTotal(cart.getQuantity()*cart.getPrice());
							c.insertproductIntoCart(cart);
						}
						else
						{
							singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()+1);
							singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
							c.updateproducttocart(singleprodfromcart.get(0));
							
						}
					}
				
			}
			catch(Exception e)
			{
				
			}
			
			return "redirect:/allpro";
		}



		@RequestMapping("/cartpage")
		String cartPage(HttpSession session,Model m)
		{
			
			String username=(String) session.getAttribute("userName");
			List<cart> singleuser=(c.singleUserCart(username));
			m.addAttribute("carobjstring", singleuser);
			return "cartpage";
		}

		@RequestMapping("/remove/{prodid}")
		String removesup(@PathVariable("prodid")int id)
		{
			if(c.deletecartproduct(id))
			{
				return "redirect:/cartpage";		
			}
			else
			{
				return "redirect:/cartpage";		
			}
		}

		@RequestMapping("/mycart")
		public String cartpage(Model m,HttpSession session)
		{
			int grandtotal=0;
			List<cart> temp=c.singleUserCart((String)session.getAttribute("userName"));
			for(cart ca:temp)
			{
				grandtotal=grandtotal+(int)ca.getTotal();
			}
			m.addAttribute("protable",c.singleUserCart((String)session.getAttribute("userName")) );
			m.addAttribute("total", grandtotal);
			
			return "cartpage";
		}

		@RequestMapping("/delcartprod/{pid}")
		String delcartpro(@PathVariable("pid") int id,HttpSession session)
		{
			c.deletecartproduct(id);
			session.isNew();
			return "redirect:/mycart";
		}
		@RequestMapping("/inccart")
		public String inccartprod(@RequestParam("getprodid") int ProdId,HttpSession session)
		{
			try
			{
				product single=pd.showone(ProdId);
					if(single.getId()==ProdId)
					{
						String username=(String) session.getAttribute("userName");
						System.out.println(username);
						List<cart> singleuser=(c.singleUserCart(username));
						for(cart c:singleuser)
						{
							System.out.println(c.getCartid()+"     "+c.getProductname());
						}
							
						List<cart> singleprodfromcart=c.singleprodfromcart(single.getName(),username);
						session.removeAttribute("prodtotal");
						if(singleprodfromcart.isEmpty())
						{
							cart cart=new cart();
							cart.setCartid((String)session.getAttribute("userName"));
							cart.setProductid(single.getId());
							cart.setPrice((int)single.getPrice());
							cart.setQuantity(1);
							cart.setProductname(single.getName());
							cart.setTotal(cart.getQuantity()*cart.getPrice());
							c.insertproductIntoCart(cart);
							
							session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("userName")).size());
						}
						else
						{
							singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()+1);
							singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
							c.updateproducttocart(singleprodfromcart.get(0));
							
							session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("userName")).size());
							
						}
					}
				
			}
			catch(Exception e)
			{
				
			}
			
			return "redirect:/mycart";
		}

			@RequestMapping("/redcart")
		public String reducacart(@RequestParam("getprodid") int ProdId,HttpSession session)
		{
			try
			{
				product single=pd.showone(ProdId);
					if(single.getId()==ProdId)
					{
						String username=(String) session.getAttribute("userName");
						System.out.println(username);
						List<cart> singleuser=(c.singleUserCart(username));
						for(cart c:singleuser)
						{
							System.out.println(c.getCartid()+"     "+c.getProductname());
						}
							
						List<cart> singleprodfromcart=c.singleprodfromcart(single.getName(),username);
						
						
						if(!singleprodfromcart.isEmpty())
						{
							
							
							if(singleprodfromcart.get(0).getQuantity()>1)
							{
								singleprodfromcart.get(0).setQuantity(singleprodfromcart.get(0).getQuantity()-1);
								singleprodfromcart.get(0).setTotal(singleprodfromcart.get(0).getPrice()*singleprodfromcart.get(0).getQuantity());
								c.updateproducttocart(singleprodfromcart.get(0));
								session.removeAttribute("prodtotal");
								session.setAttribute("prodtotal", c.singleUserCart((String)session.getAttribute("userName")).size());
							}
							
						}
					}
				
			}
			catch(Exception e)
			{
				
			}
			
			return "redirect:/mycart";
		}
			
			
			@RequestMapping("/checkout")
			public String checkout()
			{
				return "thanku";
			}

		
		}

	

