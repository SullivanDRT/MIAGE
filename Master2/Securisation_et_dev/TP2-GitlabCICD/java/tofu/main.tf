module "java_app_kube_deployment" {
  source                  = "./modules/java-app"
  image_registry_url      = var.image_registry_url
  image_registry_username = var.image_registry_username
  image_registry_password = var.image_registry_password
  image_repository        = var.image_repository
  java_app_namespace      = var.java_app_namespace
  image_tag               = var.image_tag
}
