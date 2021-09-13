import models.ManagerUser
import models.Project
import models.DevUser
import services.DevUserService

fun main() {


	val project: Project = Project("Know-Code", "Kotlin")
	val project2: Project = Project("TotalCross", "Java")
	
	var devUserService: DevUserService = DevUserService();


	val devUser: DevUser = DevUser(1, "teste", 1, ManagerUser(), arrayOf());
	
	devUserService.createProject(devUser, project);
	devUserService.createProject(devUser, project2);
	
	
	for(i in 0..devUser.projects.size - 1){
		
		println(devUser.projects.get(i).name)
		println("index of the projects are: " + devUser.projects.get(i).id)
	}
	
	println("---------------------------")
	

	devUserService.deleteProject(devUser, project.id);
	
	val project3: Project = Project("Teste", "Kotlin")
	devUserService.createProject(devUser, project3);
		
	for(i in 0..devUser.projects.size - 1){
		
		println(devUser.projects.get(i).name)
		println("index of the projects are: " + devUser.projects.get(i).id)
	}
	
	

}	