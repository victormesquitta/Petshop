export const presets = ['@babel/preset-env'];
export const plugins = [
    [
        {
            root: ['./src'],
            alias: {
                components: './src/components'
                // Adicione mais aliases conforme necessário para outros diretórios
            }
        }
    ]
];
  