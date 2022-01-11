"""
python 3.10 necessário pra rodar o exemplo se quiser tentar rodar
"""

import copy

class Person:
    def __init__(self, first_name, last_name, list):
        self.first_name = first_name
        self.last_name = last_name
        self.list = list

    #tipo um toString do java
    def __str__(self):
        return " ".join(
            ("Hash: " + str(self.__hash__()),
            "|| First Name: " + self.first_name,
            "|| Last Name: "+ self.last_name,
            "|| List: " + str(self.list))
        )

if __name__ == "__main__":
    pessoa_1 = Person("Nome", "Ficticio", [[1, 2, 3], 4, 5])
    pessoa_2 = copy.copy(pessoa_1)
    pessoa_3 = copy.deepcopy(pessoa_1)

    pessoa_2.first_name = "Usuario"
    pessoa_3.first_name = "Outro Usuario"

    pessoa_2.list.append(6)
    pessoa_3.list.clear()

    print(pessoa_1)
    print(pessoa_2)
    print(pessoa_3)
