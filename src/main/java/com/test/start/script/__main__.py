
from typing import List, Dict
import random
import requests
import json

API_BASE_URL = "http://localhost:54643"

def generate_actor(num_actor: int) -> List[Dict]:
    actors = []

    for x in range(num_actor):
        actor = {
            "firstname": f"{random.choice(['Michel', 'Jean', 'Paul', 'Jacques', 'Pierre'])}",
            "name": f"{random.choice(['Dubosc', 'Holland', 'Belmondo', 'Test'])}",
        }
        actors.append(actor)
    return actors

def adding_actors_to_api(actors: List[Dict]) -> List[str]:
    headers = {
        "Content-Type": "application/json"
    }
    for actor in actors:
        try:
            response = requests.post(f"{API_BASE_URL}/actors/", json=actor, headers=headers)
            response.raise_for_status()
            print(f"actor ajoutée avec succès")
        except requests.RequestException as error:
            print(f"Erreur lors de l'ajout de l'actor : {error}")


if __name__ == "__main__":

    num_actors = 8

    print("Génération et ajout des actors...")
    actors = generate_actor(num_actors)
    actor_ids = adding_actors_to_api(actors)
