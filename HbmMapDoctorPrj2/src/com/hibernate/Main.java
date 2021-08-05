package com.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int flag = 1;
		while (flag == 1) {

			System.out.println("1. Create Patient");
			System.out.println("2. Delete Patient");
			System.out.println("3. Update Patient");
			System.out.println("4. Read Patient");
			System.out.println("5. Exit");
			int k = sc.nextInt();
			if (k == 1) {
				Doctor doctor = new Doctor();
				sc.nextLine();
				System.out.println("Enter Doctor Name ");
				String name1 = sc.nextLine();
				doctor.setDoctor_name(name1);
				System.out.println("Enter Patient Name ");
				String name2 = sc.nextLine();
				Patients p1 = new Patients();
				p1.setPatient_name(name2);
				System.out.println("Enter address ");
				String address = sc.nextLine();
				p1.setPatient_address(address);
				System.out.println("Enter Disease ");
				String dis = sc.nextLine();
				p1.setDisease_details(dis);
				System.out.println("Enter Payment in RS. ");
				String rs = sc.nextLine();
				p1.setPayment_details(rs);
				System.out.println("Enter age ");
				int age = sc.nextInt();
				p1.setAge(age);
				p1.setDoctor(doctor);
				(doctor.getPatients()).add(p1);
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(doctor);
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				System.out.println("Patient created successful");
			} else if (k == 2) {
				System.out.println("Enter id ");
				int id = sc.nextInt();
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				Patients patient = (Patients) session.load(Patients.class, id);// delete where id=2
				session.delete(patient);
				System.out.println("Deleted Successfully");
				session.getTransaction().commit();
				sessionFactory.close();
			} else if (k == 3) {

				System.out.println("Enter id ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Updated Name");
				String str = sc.nextLine();

				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				Patients patient = (Patients) session.get(Patients.class, id);
				patient.setPatient_name(str);
				System.out.println("Updated Successfully");
				session.getTransaction().commit();
				sessionFactory.close();

			} else if (k == 4) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<Patients> patient = new ArrayList<Patients>();
				for (Object oneObject : session.createQuery("FROM Patients").getResultList()) {
					patient.add((Patients) oneObject);
				}
				for (Patients patient1 : patient) {
					System.out.println("Name: " + patient1.getPatient_name() + ", Address: "
							+ patient1.getPatient_address() + ", Disease:" + patient1.getDisease_details() + ", Age:"
							+ patient1.getAge() + ", Payment :" + patient1.getPayment_details());
				}
				session.getTransaction().commit();
				sessionFactory.close();
			} else {
				flag = 0;
				System.out.println("You are succesfully exit");
			}
		}
	}
}
