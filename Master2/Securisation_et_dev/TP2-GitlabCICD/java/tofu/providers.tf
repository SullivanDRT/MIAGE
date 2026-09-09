terraform {
  required_providers {
    helm = {
      source  = "hashicorp/helm"
      version = "3.0.2"
    }
  }
}

provider "helm" {
  kubernetes = {
    host = var.kube_host

    client_certificate     = base64decode(var.kube_client_certificate)
    client_key             = base64decode(var.kube_client_key)
    cluster_ca_certificate = base64decode(var.kube_ca_certificate)
    token                  = var.kube_token
  }
}
