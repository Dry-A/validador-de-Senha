package br.com.validador;

public class validadorSenha {

    // Método para validar a complexidade da senha
    public static boolean validarSenha(String senha) {
        // Verifica se a senha não é nula e tem pelo menos 8 caracteres
        if (senha == null || senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 8 caracteres.");
        }

        // Variáveis para verificar as condições de complexidade
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temCaractereEspecial = false;

        // Percorre cada caractere da senha
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            // Verifica se o caractere é uma letra maiúscula
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }

            // Verifica se o caractere é uma letra minúscula
            if (Character.isLowerCase(c)) {
                temMinuscula = true;
            }

            // Verifica se o caractere é um número
            if (Character.isDigit(c)) {
                temNumero = true;
            }

            // Verifica se o caractere é um caractere especial
            if (isCaractereEspecial(c)) {
                temCaractereEspecial = true;
            }
        }

        // Verifica se todas as condições de complexidade foram atendidas
        if (!temMaiuscula) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula.");
        }
        if (!temMinuscula) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra minúscula.");
        }
        if (!temNumero) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um número.");
        }
        if (!temCaractereEspecial) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um caractere especial.");
        }

        return true;
    }

    // Método auxiliar para verificar se um caractere é um caractere especial
    private static boolean isCaractereEspecial(char c) {
        // Definimos um conjunto de caracteres especiais
        char[] caracteresEspeciais = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '=', '+', '{', '}', '[', ']', ':', ';', '"', '\'', '<', '>', ',', '.', '?', '/', '\\', '|', ' '};

        // Verifica se o caractere está na lista de caracteres especiais
        for (char caractereEspecial : caracteresEspeciais) {
            if (c == caractereEspecial) {
                return true;
            }
        }
        return false;
    }

}
