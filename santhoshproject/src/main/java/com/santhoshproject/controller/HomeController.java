package com.santhoshproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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

import com.santhoshproject.dao.Registerdao;
import com.santhoshproject.dao.categorydao;
import com.santhoshproject.dao.productdao;
import com.santhoshproject.dao.supplierdao;
import com.santhoshproject.model.Register;
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

	@RequestMapping(value = {"/","/home"})
	String indexPage() {
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutusPage() {
		return "aboutus";
	}

	@RequestMapping("/contactus")
	String contactusPage() {
		return "contactus";
	}

	@RequestMapping("/signup")
	String signupPage(Model m) {
		m.addAttribute("regmodel", new Register());
		return "signup";
	}

	@RequestMapping("/getuser")
	String getuser(@Valid @ModelAttribute("regmodel") Register u, BindingResult br, Model m) {

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
	String loginPage() {
		return "login";
	}

	@RequestMapping("/addcate")
	String addcate(Model m) {
		m.addAttribute("category", new category());
		m.addAttribute("cg", cd.showall());
		m.addAttribute("check",true);
		return "addcate";
	}

	@RequestMapping("/getcategory")
	String getcategory(@Valid @ModelAttribute("category") category c, BindingResult br, Model m) {
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
	String updcat(@Valid @ModelAttribute("category") category c, BindingResult br, Model m) {
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
	String addsupp(Model m) {
		m.addAttribute("supplier", new supplier());
		m.addAttribute("cz", sd.showall());
		m.addAttribute("check",true);
		return "addsupp";
	}

	@RequestMapping("/getsupplier")
	String getsupplier(@Valid @ModelAttribute("supplier") supplier s, BindingResult br, Model m) {
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
	String updsuppr(@Valid @ModelAttribute("supplier") supplier s, BindingResult br, Model m) {
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
	String addpro(Model m) {
		m.addAttribute("product", new product());
		m.addAttribute("cv", pd.showall());
		m.addAttribute("check",true);
		return "addpro";
	}

	@RequestMapping("/getproduct")
	String getproduct(@Valid @ModelAttribute("product") product p, BindingResult br, Model m)throws Exception {
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
	String updpro(@Valid @ModelAttribute("product") product p, BindingResult br, Model m) {
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
	String delcat(@PathVariable("cid") int id)
	{
		cd.deleteuser(id);
		return "redirect:/addcate";
	}

	@RequestMapping("/editcat")
	String editcat(@RequestParam("getcatid")int id,Model m)
	{
		m.addAttribute("category",cd.showone(id));
		m.addAttribute("cg", cd.showall());
		m.addAttribute("check",false);
		return "addcate";
	}
	
	
	@RequestMapping("/delsupp/{sid}")
	String delsupp(@PathVariable("sid") int id)
	{
		sd.deleteuser(id);
		return "redirect:/addsupp";
	}

	@RequestMapping("/editsupp")
	String editsupp(@RequestParam("getsuppid")int id,Model m)
	{
		m.addAttribute("supplier",sd.showone(id));
		m.addAttribute("cz", sd.showall());
		m.addAttribute("check",false);
		return "addsupp";
	}
	
	
	@RequestMapping("/delpro/{pid}")
	String delpro(@PathVariable("pid") int id)
	{
		pd.deleteuser(id);
		return "redirect:/addpro";
	}

	@RequestMapping("/editpro")
	String editpro(@RequestParam("getproid")int id,Model m)
	{
		m.addAttribute("product",pd.showone(id));
		m.addAttribute("cv", pd.showall());
		m.addAttribute("check",false);
		return "addpro";
	}
	@RequestMapping(value={"/signin"},method=RequestMethod.GET)
	public String loginController(@RequestParam("mail") String email,@RequestParam("upass") String pass)
	{
		System.out.println(email);
		System.out.println(pass);
		List<Register> allUser=rd.showall();
		boolean userExist=false;
		for(Register reg:allUser)
		{
			if(reg.getEmail().equals(email)&&reg.getPassword().equals(pass))
			{
				userExist=true;
			}

		}		
		if(userExist)
		{
			System.out.println("Welcome Mr./Mrs. "+email);
			return "index";
		}
		else
		{
			return "login";
		}
	}
}
