package com.everis.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.proyecto.models.Usuario;
import com.everis.proyecto.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	//dependencia servivio
		private final UsuarioService us;
		public UsuarioController(UsuarioService usuarioService){
			this.us = usuarioService;
		}
		
		@RequestMapping("")
		public String index (@ModelAttribute("usuario") Usuario usuario, Model model) {
			System.out.println("index");
			
			List<Usuario> lista_usuarios = us.findAll();
			model.addAttribute("lista_usuarios", lista_usuarios);
			
			return "usuario.jsp";
		}
		
		@RequestMapping(value="/crear", method = RequestMethod.POST)
		public String crear(@Valid @ModelAttribute("usuario") Usuario usuario) {
			System.out.println("crear"+ usuario.getRut());
			
			Usuario usu = us.insertarUsuario(usuario);
			return "redirect:/usuario"; 
		}
		
		//METODO ACTUALIZAR
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		
		Usuario usuario = us.buscarUsuario(id);
		
		model.addAttribute("usuario", usuario);
		return "editar_usuario.jsp";
		}
		
		@RequestMapping(value="/modificar", method= RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
			
			System.out.println("el id a modificar es: " + usuario.getId());
			us.modificarUsuario(usuario);
			
			return "redirect:/usuario";
		}
		
		//METODO ELIMINAR
		@RequestMapping(value="/eliminar", method = RequestMethod.POST)
		public String eliminar(@RequestParam("id") Long id) {
			System.out.println("eliminar id: " + id);
			us.eliminarUsuario(id);
			
			return "redirect:/usuario";
		}
			
		@RequestMapping("/buscar")
		public String buscar() {
			return "usuario.jsp";
		}
		
	
		
}
