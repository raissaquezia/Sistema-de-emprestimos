# Sistema de Gerenciamento de Empréstimos

Este projeto é um sistema de gerenciamento de empréstimos de equipamentos desenvolvido em **Java**, permitindo realizar operações CRUD para funcionários, equipamentos e empréstimos. Ele inclui as seguintes funcionalidades:

- Cadastrar, atualizar, excluir e consultar funcionários.
- Cadastrar, atualizar, excluir e consultar equipamentos.
- Registrar e gerenciar empréstimos de equipamentos por funcionários.
- Controlar a disponibilidade dos equipamentos.

O sistema também utiliza um **enum** para gerenciar o estado de conservação dos equipamentos com os seguintes estados:
- Ruim
- Bom
- Ótimo

### Validações:
- Empréstimos só podem ser realizados com funcionários e equipamentos cadastrados e disponíveis.
- O sistema impede que equipamentos não disponíveis sejam emprestados.

---

### Desenvolvido por:
- Raissa Quezia
- Maria Ellen
