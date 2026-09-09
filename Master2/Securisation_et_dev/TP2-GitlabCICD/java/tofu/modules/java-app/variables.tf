variable "java_app_namespace" {
  type        = string
  description = "Namespace targeted to deploy java app"
  default     = "javaspace"
}

variable "image_repository" {
  type        = string
  description = "Container repository of the image"
}

variable "image_tag" {
  type        = string
  description = "Tag of the image"
  default     = "main"
}

variable "image_registry_url" {
  type        = string
  description = "URL of image registry"
  default     = "registry.gitlab.com"
}

variable "image_registry_username" {
  type        = string
  description = "Username to access image registry"
}

variable "image_registry_password" {
  type        = string
  description = "Password to access image registry"
  sensitive   = true
}
