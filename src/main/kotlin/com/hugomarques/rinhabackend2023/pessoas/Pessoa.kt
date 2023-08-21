package com.hugomarques.rinhabackend2023.pessoas

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "pessoas")
class Pessoa {

    @JvmField
    @Id
    var id: UUID? = null

    @JvmField
    @Column(nullable = false, unique = true, length = 32)
    var apelido: String? = null

    @Column(nullable = false, length = 100)
    var nome: String? = null

    @Column(nullable = false)
    var nascimento: String? = null

    @Column(nullable = true)
    @Convert(converter = StringListConverter::class)
    var stack: List<String>? = null

    constructor()

    constructor(apelido: String?, nome: String?, nascimento: String?, stack: List<String>?) {
        this.apelido = apelido
        this.nome = nome
        this.nascimento = nascimento
        this.stack = stack
    }
}
