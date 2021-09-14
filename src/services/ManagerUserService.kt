package services

import models.ManagerUser

import models.DevUser
import models.Project

class ManagerUserService {

	fun addCreditsToThemselves(manager: ManagerUser, credits: Int) {
		manager.credits += credits;
	}

	fun removeCreditsToThemselves(manager: ManagerUser, credits: Int) {
		manager.credits -= credits;
	}

	fun addCreditsToDevs(dev: DevUser, credits: Int) {
		dev.credits += credits;
	}

	fun removeCreditsToDevs(dev: DevUser, credits: Int) {
		dev.credits -= credits;
	}

	fun createProject(manager: ManagerUser, project: Project) {

		// A way to iterate the projects entity and incremeting 1 into their id's
		project.id = manager.projects.size + 1;
		manager.projects.add(project);

	}

	fun deleteProject(manager: ManagerUser, projectId: Int) {
		manager.projects.removeAt(projectId - 1)


		// Avoid the duplicate IDs after the delete
		for (i in projectId - 1..manager.projects.size - 1) {
			manager.projects.get(i).id -= 1;
		}
	}


}