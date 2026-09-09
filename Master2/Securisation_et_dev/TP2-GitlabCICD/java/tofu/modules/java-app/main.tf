resource "helm_release" "java_app" {
  name    = "java-app"
  chart   = "${path.module}/helm"
  version = "0.1.0"

  namespace        = var.java_app_namespace
  create_namespace = true

  set = [
    {
      name  = "image.repository",
      value = var.image_repository
    },
    {
      name  = "image.tag",
      value = var.image_tag
    },
    {
      name  = "imageCredentials.registry",
      value = var.image_registry_url
    },
    {
      name  = "imageCredentials.username",
      value = var.image_registry_username
    },
    {
      name  = "imageCredentials.password",
      value = var.image_registry_password
    },
  ]
}
