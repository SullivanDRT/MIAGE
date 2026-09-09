variable "kube_host" {
  type        = string
  description = "The host of the Kubernetes cluster with procotol, hostname/ip and port"
}

variable "kube_client_certificate" {
  type        = string
  description = "The pem client certificate of the Kubernetes cluster"
  sensitive   = true
}

variable "kube_client_key" {
  type        = string
  description = "The pem client key of the Kubernetes cluster"
  sensitive   = true
}

variable "kube_ca_certificate" {
  type        = string
  description = "The pem CA certificate of the Kubernetes cluster"
  sensitive   = true
}

variable "kube_token" {
  type        = string
  description = "The token to authenticate to Kubernetes cluster"
  sensitive   = true
}

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
