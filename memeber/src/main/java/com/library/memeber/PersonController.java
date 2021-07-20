package com.library.memeber;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;

	@RequestMapping("/allPersons")
	public String getAllPersons(Model boxToView) {
		
		System.out.println("Array1: " +  personRepository.findAll());

		boxToView.addAttribute("personListfromControllerAndDB", personRepository.findAll());
		
		System.out.println("Array2: " +  personRepository.findAll());

			return "persons";
		}

	// Borrar persones
	@RequestMapping("/deletePerson")
	public String removePerson(int id, Model model) {

			// System.out.println("inside removeEmployee" + id);
			Optional<Person> personFound = findOnePersonById(id);

			// System.out.println("find inside removePerson" + personFound.get());

			if (personFound.isPresent()) {

				personRepository.deleteById(id);
				model.addAttribute("message", "done");
				model.addAttribute("personDeleted", personFound.get());
			}

			else {
				model.addAttribute("message", "error");
			}

			// System.out.println("finishing removePerson" + id);
			return "deleteperson.html";
		}

		@RequestMapping("/deleteAllPersons")
		public String deleteAllPersons () {

			
			personRepository.deleteAll();
			

			return "redirect:/person/allPersons";

		}
		
		// Afegir Persones
		
		@RequestMapping("/newPerson")
		public String newPerson() {

			return "newperson.html";
		}

		@RequestMapping("/addPerson")
		public String inserPerson(Person person) {

			personRepository.save(person);

			return "redirect:/person/allPersons";
		}

		// modificar Persones
		@RequestMapping("/updatePerson")
		public String updatePerson(int id, Model model) {

			Optional<Person> personFound = findOnePersonById(id);

			if (personFound.isPresent()) {

				model.addAttribute("personfromController", personFound.get());
				return "updateperson";
			}

			else
				return "notfound.html";
		}

		@PostMapping("/replacePerson/{idFromView}")
		public String replacePerson(@PathVariable("idFromView") int id, Person person) {

			Optional<Person> personFound = findOnePersonById(id);

			if (personFound.isPresent()) {

				if (person.getName() != null)
					personFound.get().setName(person.getName());
				if (person.getSurname() != null)
					personFound.get().setSurname(person.getSurname());
				if (person.getAge() != 0)
					personFound.get().setAge(person.getAge());
				if (person.getEmail() != null)
					personFound.get().setEmail(person.getEmail());
				if (person.getAge() != 0)
					personFound.get().setAge(person.getAge());
				if (person.getLocation() != null)
					personFound.get().setLocation(person.getLocation());

				personRepository.save(personFound.get());
				return "redirect:/person/allPersons";

			} else
				return "notfound.html";

		}
		
		// Informació de Person
		@RequestMapping("/detailPerson")
		public String detailPerson(int id, Model model) {

			Optional<Person> personFound = findOnePersonById(id);

			if (personFound.isPresent()) {

				model.addAttribute("personfromController", personFound.get());
				return "detailperson";
			}

			else
				return "notfound.html";
		}
		
	
	//Servei al controllador, el que fà, es declarar una funció  amb el paràmetre Id, per que busqui a personRepository la person del Id y la 
		//guardi a personFound
	

		public Optional<Person> findOnePersonById(int id) {

			// System.out.println("inside findPerson" + id);
			Optional<Person> personFound = personRepository.findById(id);
			// System.out.println("finishing findPerson" + id);
			// System.out.println("finishing findPerson" + personFound.get());
			return personFound;
		}

	}


