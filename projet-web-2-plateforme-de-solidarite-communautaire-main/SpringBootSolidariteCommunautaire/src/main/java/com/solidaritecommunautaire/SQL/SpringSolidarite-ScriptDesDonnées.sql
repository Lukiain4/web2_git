-- -----------------------------------------------------
-- Schema springsolidarite
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springsolidarite` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `springsolidarite` ;

-- Insertion de données dans la table 'administrateurs'
INSERT INTO `springsolidarite`.`administrateurs` (`id`, `email`, `password`) VALUES 
(1,'jean.dupont@email.com','jean1'),
(2,'sophie.lefevre@email.com','sophie1'),
(3,'marie.durand@email.com','marie1'),
(4,'antoine.lavoie@email.com','antoine1'),
(5,'emilie.bouvier@email.com','emilie1'),
(6,'philippe.bergeron@email.com','philippe1');

INSERT INTO `springsolidarite`.`roles` (`id`, `nom`, `description`) VALUES 
(1,'Administrateur','Gère et administre le système de solidarité communautaire.'),
(2,'Organisateur','Organise et coordonne les événements et les actions solidaires.'),
(3,'Individu solidaire','Participe activement aux projets solidaires et soutient les organisations.');

INSERT INTO `springsolidarite`.`individus` (`id`, `nom`, `prenom`, `email`, `password`, `role_id`) VALUES 
(1,'Dupont','Jean','jean.dupont@email.com','jean1',1),
(2,'Durand','Marie','marie.durand@email.com','marie1',2),
(3,'Martin','Pierre','pierre.martin@email.com','pierre1',3),
(4,'Lefevre','Sophie','sophie.lefevre@email.com','sophie1',1),
(5,'Garcia','Julien','julien.garcia@email.com','julien1',3),
(6,'Bouvier','Émilie','emilie.bouvier@email.com','emilie1',2),
(7,'Lavoie','Antoine','antoine.lavoie@email.com','antoine1',1),
(8,'Côté','Mélissa','melissa.cote@email.com','melissa1',3),
(9,'Bergeron','Philippe','philippe.bergeron@email.com','philippe1',2),
(10,'Gagnon','Camille','camille.gagnon@email.com','camille1',3);

-- Insertion de données dans la table 'administrateurs_individus'
INSERT INTO `springsolidarite`.`administrateurs_individus` (`administrateur_id`, `individu_id`) VALUES 
(1,1),
(2,4),
(4,7);

-- Insertion de données dans la table 'organisateurs'
INSERT INTO `springsolidarite`.`organisateurs` (`id`, `nom`, `prenom`, `email`, `password`, `role_id`) VALUES 
(1,'Durand','Marie','marie.durand@email.com','marie1',2),
(2,'Bouvier','Émilie','emilie.bouvier@email.com','emilie1',2),
(3,'Bergeron','Philippe','philippe.bergeron@email.com','philippe1',2);

-- Insertion de données dans la table 'administrateurs_organisateurs'
INSERT INTO `springsolidarite`.`administrateurs_organisateurs` (`administrateur_id`, `organisateur_id`) VALUES 
(3,1),
(5,2),
(6,3);

-- Insertion de données dans la table 'associations'
INSERT INTO `springsolidarite`.`associations` (`id`,`nom_association`, `email`, `password`,`photo`) VALUES
(1,'Association Aide et Partage','aide_et_partage@email.com','aideetpartage','aide-partage.png'),
(2,'Association Entraide Locale','entraide_locale@email.com','entraidelocale','entraide-locale.png'),
(3,'Association Solidarité Citoyenne','solidarite_citoyenne@email.com','solidaritécitoyenne','solidariter-citoyenne.png');

-- Insertion de données dans la table 'campagnes'
INSERT INTO `springsolidarite`.`campagnes` (`id`,`nom`, `description`, `photo`, `fond`, `association_id`) VALUES
(1,'Campagne de d\'aide Alimentaire','Distribution de repas aux personnes dans le besoin','aide-alimentaire.png',35000.00,1),
(2,'Campagne de Partage de Vêtements','Collecte et distribution de vêtements pour les personnes défavorisées','partage-vetement.png',50000.00,1),
(3,'Campagne de Soutien aux Personnes Âgées','Aide et accompagnement aux personnes âgées isolées','soutien-personne-agee.png',75000.00,2),
(4,'Campagne d\'Aide aux Familles en Difficulté','Soutien aux familles en situation de précarité','aide-famille-difficultee.png',100000.00,2),
(5,'Campagne de Rénovation des Espaces Urbains','Amélioration des infrastructures urbaines pour un cadre de vie meilleur','renovation-urbain.png',250000.00,3),
(6,'Campagne de Sensibilisation à l\'Environnement','Actions pour sensibiliser à la protection de l\'environnement','sensibilisation-environement.png',150000.00,3);

-- Insertion de données dans la table 'organisations'
INSERT INTO `springsolidarite`.`organisations` (`id`, `nom`, `description`) VALUES 
(1, 'Collectif Solidaire pour l\'Entraide', 'Organisation collaborative pour soutenir les personnes en difficulté.'),
(2, 'Fondation de l\'Amitié', 'Fondation dédiée à renforcer les liens communautaires par divers projets de solidarité.'),
(3, 'Aide Mutuelle', 'Favoriser l\'aide mutuelle et l\'entraide au sein des quartiers.');

-- Insertion de données dans la table 'projets'
INSERT INTO `springsolidarite`.`projets` (`id`,`nom`,`description`, `organisation_id`) VALUES 
(1,'Projet Solidarité Psychosociale', 'Soutien psychologique et social aux personnes en difficulté.', 1),
(2,'Projet Éducation Solidaire','Ateliers d\'apprentissage pour les jeunes défavorisés.', 1),
(3, 'Programme de Soutien Scolaire', 'Projet visant à offrir du soutien scolaire et des activités éducatives aux enfants défavorisés, permettant de combler les lacunes et de favoriser leur réussite académique.',2),
(4, 'Ateliers de Réinsertion Sociale', 'Projet destiné à aider les personnes en situation de précarité à se réinsérer socialement et professionnellement grâce à des ateliers de formation et de développement de compétences.',2),
(5, 'Projet Logement Digne', 'Aide à la rénovation et à l\'amélioration des conditions de logement pour les personnes en situation précaire', 3),
(6,'Projet de sensibilisation communautaire', 'Organiser des événements de sensibilisation pour promouvoir l\'entraide et la solidarité dans les quartiers.',3);

-- Insertion de données dans la table 'individus_projets'
INSERT INTO `springsolidarite`.`individus_projets` (`individu_id`, `projet_id`) VALUES
(1,5),
(2,1),
(2,2),
(3,1),
(4,2),
(5,4),
(6,3),
(6,4),
(7,6),
(8,5),
(9,5),
(9,6),
(10,6);

INSERT INTO `springsolidarite`.`initiative_caritative` (`id`, `nom`, `description`, `individu_id`) VALUES
(1, 'Collecte Alimentaire Solidaire', 'Une initiative visant à collecter des denrées alimentaires pour les familles dans le besoin de la communauté.',3),
(2, 'Ateliers de Réparation Solidaire', 'Des ateliers où les membres de la communauté peuvent réparer des objets cassés ou endommagés gratuitement ou à faible coût.',7),
(3, 'Jardin Communautaire', 'Un projet visant à créer des jardins partagés où les résidents peuvent cultiver leurs propres fruits et légumes, favorisant ainsi l\'entraide et la sécurité alimentaire.',10);

-- Insertion de données dans la table 'organisateurs_projets'
INSERT INTO `springsolidarite`.`organisateurs_projets` (`organisateur_id`, `projet_id`) VALUES 
(1,5),
(1,6),
(2,1),
(2,2),
(3,3),
(3,4);
