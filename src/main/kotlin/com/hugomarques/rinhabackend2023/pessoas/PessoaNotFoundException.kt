package com.hugomarques.rinhabackend2023.pessoas

import java.util.UUID

class PessoaNotFoundException internal constructor(id: UUID) : RuntimeException("Pessoa com id: $id não encontrada.")
