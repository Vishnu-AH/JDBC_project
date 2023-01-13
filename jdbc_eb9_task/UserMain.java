package jdbc_eb9_task;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		boolean flag = true;
		User user = new User();
		UserCrud userCrud = new UserCrud();
		
		do {
			System.out.println("~~~~~~Press~~~~~~");
			System.out.println("1-->Signup");
			System.out.println("2-->Login");
			System.out.println("3-->Display all user details");
			System.out.println("4-->Update user details");
			System.out.println("5-->Delete a user ");
			System.out.println("6-->Exit");
			System.out.print("Enter the choice : ");
			int choice = scanner.nextInt();
			System.out.println();
			switch(choice) {
			case 1 :{
				System.out.print("Enter the userid : ");
				int userid = scanner.nextInt();
				System.out.print("Enter the username : ");
				String username = scanner.next();
				System.out.print("Enter the email id : ");
				String email = scanner.next();
				System.out.print("Enter the password : ");
				String password = scanner.next();
				System.out.print("Enter the address : ");
				String address = scanner.next();
				
				user.setUserid(userid);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);
				try {
					userCrud.signUp(user);
				} catch (Exception e) {
					System.out.println("Something went wrong");
				}
			}
			break;
			
			case 2 : {
				System.out.print("Enter your email : ");
				String email = scanner.next();
				System.out.print("Enter the password : ");
				String password = scanner.next();
				user.setEmail(email);
				user.setPassword(password);
				
				try {
					boolean result = userCrud.loginUser(user);
					if(result == true) {
						boolean condition = true;
						System.out.println("Loggedin successfully...!!");
						do {
						System.out.println("~~~~~~Press~~~~~~");
						System.out.println("1-->To enter facebook password ");
						System.out.println("2-->To enter instagram password ");
						System.out.println("3-->To enter snapchat password ");
						System.out.println("4-->To enter whatsapp password ");
						System.out.println("5-->To enter twitter pssword ");
						System.out.println("6-->Exit");
						System.out.print("Enter your choice : ");
						int choice1 = scanner.nextInt();
						System.out.println();
						switch(choice1) {
						case 1 :{
							System.out.print("Enter facebook password : ");
							String fbPassword = scanner.next();
							String fbOldPswd = userCrud.fetchFacebook(email);
							if(fbOldPswd==null) {
								userCrud.facebook(email, fbPassword);
								System.out.println("Password inserted successfully...!!");
							}
							else {
								System.out.println("Password already exists...");
								System.out.println("Your facebook password is : "+fbOldPswd);
								System.out.println("Do you want to update the password ?");
								System.out.print("Press Y for Yes and N for No : ");
								char updateChoice = scanner.next().charAt(0);
								if(updateChoice == 'Y' || updateChoice =='y') {
									userCrud.facebook(email, fbPassword);
									System.out.println("Facebook password updated successfully...!!");
									System.out.println("Your new password is : "+fbPassword);
								}
								else {
									System.out.println("Thank you...");
								}
							}
						}
						break;
						case 2 : {
							System.out.print("Enter Instagram password : ");
							String instaPassword = scanner.next();
							String instaOldPswd = userCrud.fetchInsta(email);
							if(instaOldPswd==null) {
								userCrud.instagram(email, instaPassword);
								System.out.println("Password saved successfully...!!");
							}
							else {
								System.out.println("Password already exists...");
								System.out.println("Your instagram password is : "+instaOldPswd);
								System.out.println("Do you want to update the password ?");
								System.out.print("Press Y for Yes and N for No : ");
								char updateChoice = scanner.next().charAt(0);
								if(updateChoice == 'Y' || updateChoice =='y') {
									userCrud.instagram(email, instaPassword);
									System.out.println("Instagram password updated successfully...!!");
									System.out.println("Your new password is : "+instaPassword);
								}
								else {
									System.out.println("Thank you...");
								}
							}
						}
						break;
						case 3 : {
							System.out.print("Enter snapchat password : ");
							String snapPassword = scanner.next();
							String snapOldPswd = userCrud.fetchSnap(email);
							if(snapOldPswd==null) {
								userCrud.snapchat(email, snapPassword);
								System.out.println("Password saved successfully...!!");
							}
							else {
								System.out.println("Password already exists...");
								System.out.println("Your snapchat password is : "+snapOldPswd);
								System.out.println("Do you want to update the password ?");
								System.out.print("Press Y/y for Yes and N/n for No : ");
								char updateChoice = scanner.next().charAt(0);
								if(updateChoice == 'Y' || updateChoice =='y') {
									userCrud.snapchat(email, snapPassword);
									System.out.println("Snapchat password updated successfully...!!");
									System.out.println("Your new password is : "+snapPassword);
								}
								else {
									System.out.println("Thank you...");
								}
							}
						}
						break;
						case 4 : {
							System.out.print("Enter whatsapp password : ");
							String whatsappPassword = scanner.next();							
							String whatsappOldPswd = userCrud.fetchWhatsapp(email);
							if(whatsappOldPswd==null) {
								userCrud.whatsapp(email, whatsappPassword);								
								System.out.println("Password saved successfully...!!");
							}
							else {
								System.out.println("Password already exists...");
								System.out.println("Your whatsapp password is : "+whatsappOldPswd);
								System.out.println("Do you want to update the password ?");
								System.out.print("Press Y/y for Yes and N/n for No : ");
								char updateChoice = scanner.next().charAt(0);
								if(updateChoice == 'Y' || updateChoice =='y') {
									userCrud.whatsapp(email, whatsappPassword);
									System.out.println("Whatsapp password updated successfully...!!");
									System.out.println("Your new password is : "+whatsappPassword);
								}
								else {
									System.out.println("Thank you...");
								}
							}
						}
						break;
						case 5 : {
							System.out.println("Enter twitter password : ");
							String twitterPassword = scanner.next();
							String twitterOldPswd = userCrud.fetchTwitter(email);
							if(twitterOldPswd==null) {
								userCrud.twitter(email, twitterPassword);							
								System.out.println("Password saved successfully...!!");
							}
							else {
								System.out.println("Password already exists...");
								System.out.println("Your twitter password is : "+twitterOldPswd);
								System.out.println("Do you want to update the password ?");
								System.out.print("Press Y/y for Yes and N/n for No : ");
								char updateChoice = scanner.next().charAt(0);
								if(updateChoice == 'Y' || updateChoice =='y') {
									userCrud.twitter(email, twitterPassword);
									System.out.println("Twitter password updated successfully...!!");
									System.out.println("Your new password is : "+twitterPassword);
								}
								else {
									System.out.println("Thank you...");
								}
							}
						}
						case 6 : {
							condition = false;
						}
						}
						}while(condition);	
					}else {
						System.out.println("Incorrect password...!!");
					}
				} catch (Exception e) {
					System.out.println("Something went wrong...!!");
				}
			}break;
			case 3 : {
				try {
					System.out.println("~~~~~~Users list~~~~~~");
					userCrud.fetchUser();
				} catch (Exception e) {
					System.out.println("Something went wrong...!!");
				}
			}break;
			case 4 : {
				System.out.print("Enter the id to be updated : ");
				int id = scanner.nextInt();
				System.out.print("Enter the name to be updated : ");
				String name = scanner.next();
				try {
					userCrud.updateUser(id,name);
				} catch (Exception e) {
					System.out.println("Something went wrong...!!");
				}
			}break;
			case 5 : {
				try {
					System.out.println("Enter the id : ");
					int id = scanner.nextInt();
					userCrud.deleteUser(id);
				} catch (Exception e) {
					System.out.println("Something went wrong...!!");
				}
			}
			break;
			case 6 : {
				flag = false;
			}
			}
		} while (flag);
		System.out.println("Thank you... visit again...!!");
	}
}