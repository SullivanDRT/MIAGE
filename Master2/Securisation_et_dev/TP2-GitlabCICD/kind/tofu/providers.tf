terraform {
  required_providers {
    kind = {
      source  = "tehcyx/kind"
      version = "0.9.0"
    }

    kubernetes = {
      source  = "hashicorp/kubernetes"
      version = "2.38.0"
    }

    helm = {
      source  = "hashicorp/helm"
      version = "3.0.2"
    }
  }
}

provider "kind" {}
provider "kubernetes" {
  config_path = local_sensitive_file.kubeconfig.filename
}
provider "helm" {
  kubernetes = {
    config_path = local_sensitive_file.kubeconfig.filename
  }
}
