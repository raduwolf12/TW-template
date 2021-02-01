package com.examen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.examen.model.DateVal;
import com.examen.model.Proces;
import com.examen.model.ScorEvaluare;
import com.examen.model.User;
import com.examen.repository.ProcesRepository;
import com.examen.repository.ScorEvaluareRepository;
import com.examen.repository.UserRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProcesRepository procesRepository;

	@Autowired
	private ScorEvaluareRepository scorEvaluareRepository;
	
	@Autowired
	HttpSession ses;

	@RequestMapping({ "/index", "/" })
	public RedirectView login(@RequestParam("username") String name, @RequestParam("password") String password,
			Model model) {

		Long id = userRepository.getByUserNameAndPassword(name, password).getId();
		return new RedirectView("/eval?id=" + id);

	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(Authentication authentication) {
		authentication.setAuthenticated(false);
		ses.invalidate();
		return "login";

	}

	@RequestMapping("notFound")
	public String notFound() {

		return "oops";

	}

	@RequestMapping("/eval")
	public String eval(Authentication authentication, Model model) {

		User user = userRepository.getByUserNameAndPassword(authentication.getName(),
				authentication.getPrincipal().toString());

		model.addAttribute("user", user);
		return "evaluare";
	}

	@GetMapping("submitevaluare")
	public String submitEval(@RequestParam("group1") String group1, @RequestParam("group2") String group2,
			@RequestParam("group3") String group3, @RequestParam("group4") String group4,
			@RequestParam("group5") String group5, @RequestParam("group6") String group6,
			@RequestParam("group7") String group7, @RequestParam("group8") String group8,
			@RequestParam("group9") String group9, @RequestParam("group10") String group10,
			@RequestParam("group11") String group11, @RequestParam("id") String id, Model model) {

		int scorV = 0;
		Long v = Long.valueOf(group1);
		scorV += v.intValue();
		v = Long.valueOf(group2);
		scorV += v.intValue();
		v = Long.valueOf(group3);
		scorV += v.intValue();
		v = Long.valueOf(group4);
		scorV += v.intValue();
		v = Long.valueOf(group5);
		scorV += v.intValue();
		v = Long.valueOf(group6);
		scorV += v.intValue();
		v = Long.valueOf(group7);
		scorV += v.intValue();
		v = Long.valueOf(group8);
		scorV += v.intValue();
		v = Long.valueOf(group9);
		scorV += v.intValue();
		v = Long.valueOf(group10);
		scorV += v.intValue();
		v = Long.valueOf(group11);
		scorV += v.intValue();

		model.addAttribute("scor", scorV);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		String dataCur = formatter.format(date);

		User user = userRepository.findById(Long.valueOf(id)).get();
		List<Proces> procese = user.getProces();
		if (procese == null) {
			procese = new ArrayList<Proces>();
		}

		Proces proces1 = new Proces();
//		1
		ScorEvaluare scor = scorEvaluareRepository.findById(Long.valueOf(group1)).get();
		proces1.setId_scor(scor);
		proces1.setDate(dataCur);
		proces1.setNume("Controlul procesului de definire a unui plan strategic de informatizare");
		procesRepository.save(proces1);
		procese.add(proces1);

//		2
		Proces proces2 = new Proces();
		ScorEvaluare scor1 = scorEvaluareRepository.findById(Long.valueOf(group2)).get();
		proces2.setId_scor(scor1);
		proces2.setDate(dataCur);
		proces2.setNume("Controlul procesului de definire a arhitecturii informaţionale");
		procesRepository.save(proces2);
		procese.add(proces2);

//		3
		Proces proces3 = new Proces();
		ScorEvaluare scor2 = scorEvaluareRepository.findById(Long.valueOf(group3)).get();
		proces3.setId_scor(scor2);
		proces3.setDate(dataCur);
		proces3.setNume("Controlul procesului de determinare a direcţiilor de dezvoltare tehnică");
		procesRepository.save(proces3);
		procese.add(proces3);

//		4
		Proces proces4 = new Proces();
		ScorEvaluare scor4 = scorEvaluareRepository.findById(Long.valueOf(group4)).get();
		proces4.setId_scor(scor4);
		proces4.setDate(dataCur);
		proces4.setNume("Controlul procesului de definire a modalităţii de organizare a tehnologiei informaţiei");
		procesRepository.save(proces4);
		procese.add(proces4);

//		5
		Proces proces5 = new Proces();
		ScorEvaluare scor5 = scorEvaluareRepository.findById(Long.valueOf(group5)).get();
		proces5.setId_scor(scor5);
		proces5.setDate(dataCur);
		proces5.setNume("Controlul procesului de management a investiţiilor în T.I.");
		procesRepository.save(proces5);
		procese.add(proces5);

//		6
		Proces proces6 = new Proces();
		ScorEvaluare scor6 = scorEvaluareRepository.findById(Long.valueOf(group6)).get();
		proces6.setId_scor(scor6);
		proces6.setDate(dataCur);
		proces6.setNume("Controlul procesului de comunicare a obiectivelor şi direcţiilor de management");
		procesRepository.save(proces6);
		procese.add(proces6);

//		7
		Proces proces7 = new Proces();
		ScorEvaluare scor7 = scorEvaluareRepository.findById(Long.valueOf(group7)).get();
		proces7.setId_scor(scor7);
		proces7.setDate(dataCur);
		proces7.setNume("Controlul procesului de conducere a resurselor umane");
		procesRepository.save(proces7);
		procese.add(proces7);

//		8
		Proces proces8 = new Proces();
		ScorEvaluare scor8 = scorEvaluareRepository.findById(Long.valueOf(group8)).get();
		proces8.setId_scor(scor8);
		proces8.setDate(dataCur);
		proces8.setNume(" Controlul procesului de asigurare a acordului cu cerinţele externe");
		procesRepository.save(proces8);
		procese.add(proces8);

//		9
		Proces proces9 = new Proces();
		ScorEvaluare scor9 = scorEvaluareRepository.findById(Long.valueOf(group9)).get();
		proces9.setId_scor(scor9);
		proces9.setDate(dataCur);
		proces9.setNume("Controlul procesului de evaluare a riscurilor");
		procesRepository.save(proces9);
		procese.add(proces9);

//		10
		Proces proces10 = new Proces();
		ScorEvaluare scor10 = scorEvaluareRepository.findById(Long.valueOf(group10)).get();
		proces10.setId_scor(scor10);
		proces10.setDate(dataCur);
		proces10.setNume("Controlul procesului de administrare a proiectelor");
		procesRepository.save(proces10);
		procese.add(proces10);

//		11
		Proces proces11 = new Proces();
		ScorEvaluare scor11 = scorEvaluareRepository.findById(Long.valueOf(group11)).get();
		proces11.setId_scor(scor11);
		proces11.setDate(dataCur);
		proces11.setNume("Controlul procesului de administrare a calităţii");
		procesRepository.save(proces11);
		procese.add(proces11);
		userRepository.save(user);

		model.addAttribute("user", user);
		return "evaluare2";
	}

	@GetMapping("home")
	public String home(@RequestParam("id") String id, Model model) {
		User user = userRepository.findById(Long.valueOf(id)).get();
		model.addAttribute("user", user);

		List<Proces> procese = user.getProces();
		int size = procese.size();
		List<DateVal> dates = new ArrayList<DateVal>();

		for (int i = 0; i < size; i = i + 11) {
			DateVal dateVals = new DateVal(procese.get(i).getDate(), i);
			dates.add(dateVals);
		}

		model.addAttribute("breaks", dates);

		return "acasa";
	}

	@GetMapping("download/{id}/{val}")
	public void download(@PathVariable("id") String id, @PathVariable("val") String val, Model model,
			HttpServletResponse response) throws DocumentException, IOException {
		User user = userRepository.findById(Long.valueOf(id)).get();
		model.addAttribute("user", user);

		List<Proces> procese = user.getProces();
		int size = procese.size();
		List<DateVal> dates = new ArrayList<DateVal>();

		for (int i = 0; i < size; i = i + 11) {
			DateVal dateVals = new DateVal(procese.get(i).getDate(), i);
			dates.add(dateVals);
		}

		model.addAttribute("breaks", dates);

		List<Proces> proces2 = new ArrayList<Proces>();

		for (int i = Integer.valueOf(val); i < Integer.valueOf(val) + 11; i++)
			proces2.add(procese.get(i));

		Document document = new Document();
		String numeDoc = "raport4_" + proces2.get(0).getDate().toString() + ".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(numeDoc));

		document.open();
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, BaseColor.BLACK);
		Font fontM = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
		Font descris = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, BaseColor.DARK_GRAY);

		for (Proces p : proces2) {
			String nume = p.getNume();
			int sizeTmp = nume.length();

			Chunk chunk = new Chunk(nume, fontM);
			document.add(chunk);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			String numeScor = p.getId_scor().getNume();
			Chunk chunk1 = new Chunk(numeScor, font);
			document.add(chunk1);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			String descriereScor = p.getId_scor().getDescriere();
			Chunk chunk2 = new Chunk(descriereScor, descris);
			document.add(chunk2);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(new Phrase("\n"));

		}

		document.close();

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
		InputStream inputStream = new FileInputStream(new File("E:/Download/vvss - minisoft/" + numeDoc));
		int nRead;
		while ((nRead = inputStream.read()) != -1) {
			response.getWriter().write(nRead);
		}
	}

}
