package services

import models.DevUser
import models.Project

class DevUserService {


	fun createProject(user: DevUser, project: Project) {
		
		// A way to iterate the projects entity and incremeting 1 into their id's
		project.id = user.projects.size + 1;
		user.projects.add(project);

	}

	fun deleteProject(user: DevUser, projectId: Int) {
		user.projects.removeAt(projectId - 1)
		
		
		// Avoid the duplicate IDs after the delete
		for (i in projectId - 1..user.projects.size - 1){
			user.projects.get(i).id -= 1;
		}
	}
	
	
	

}