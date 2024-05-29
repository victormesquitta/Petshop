import { FaSearch, FaArrowLeft, FaPlusCircle } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import * as S from './styles';
import { useState, useEffect } from 'react';
import { categoriaService } from '../../services/categoria.service';
import { subcategoriaService } from '../../services/subcategoria.service';
import { toast, ToastContainer } from 'react-toastify';

export function AdminSubCategoria() {
  const navigate = useNavigate();
  const [categorias, setCategorias] = useState([]);
  const [novaSubCategoria, setNovaSubCategoria] = useState({
    nome: '',
    descricao: '',
    codCategoria: '' // Valor inicial vazio para o select
  });

  useEffect(() => {
    // Buscar todas as categorias ao carregar o componente
    const carregarCategorias = async () => {
      try {
        const data = await categoriaService.findAllCategorias(); // Corrigido para findAllCategorias
        setCategorias(data.content);
      } catch (error) {
        console.error("Erro ao buscar categorias:", error);
        toast.error('Erro ao carregar categorias. Por favor, tente novamente.');
      }
    };

    carregarCategorias();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNovaSubCategoria({ ...novaSubCategoria, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // Adicione a categoria ao objeto novaSubCategoria antes de criar
      const subcategoriaCriar = {
        ...novaSubCategoria,
        codCategoria: parseInt(novaSubCategoria.codCategoria, 10) // Converte para inteiro
      };
      await subcategoriaService.create(subcategoriaCriar); // Use o serviço para criar a subcategoria
      toast.success('Subcategoria cadastrada com sucesso!');
      // Limpar os campos após o cadastro
      setNovaSubCategoria({
        nome: '',
        descricao: '',
        codCategoria: '' // Limpar o select
      });
    } catch (error) {
      console.error("Erro ao cadastrar subcategoria:", error);
      toast.error('Erro ao cadastrar subcategoria. Por favor, tente novamente.');
    }
  };

  return (
    <>
      <ToastContainer />
      <S.ContainerPai>
        <div className='divDashBoard'>
          <img src={ImgLogo} alt="Logo" />
          <h1>DashBoard</h1>
          <Link to={'/'} className='Link'><FaArrowLeft className='icons' />Voltar</Link>
        </div>

        <div className='divPrincipal'>
          <section className='section1'>
            <input placeholder='Pesquisar' className='InputPesquisar' />
            <FaSearch className="IconLupa" />
          </section>

          <div>
            <section className='section2'>
              <h1>Nova Subcategoria</h1>

              <label htmlFor="nome">Nome da Subcategoria:</label>
              <input
                type="text"
                id="nome"
                name="nome"
                value={novaSubCategoria.nome}
                onChange={handleChange}
                className='InputNomeCat'
              />

              <label htmlFor="descricao">Descrição da Subcategoria:</label>
              <textarea
                id="descricao"
                name="descricao"
                value={novaSubCategoria.descricao}
                onChange={handleChange}
                className='InputDescriCat'
              />

              <label htmlFor="categoria">Categoria:</label>
              <select
                id="categoria"
                name="codCategoria"
                value={novaSubCategoria.codCategoria} 
                onChange={handleChange}
                className='InputDescriCat'
              >
                <option value="">Selecione uma categoria</option> 
                {categorias.map((categoria) => (
                  <option key={categoria.codCategoria} value={categoria.codCategoria}>
                    {categoria.nome}
                  </option>
                ))}
              </select>

              <button onClick={handleSubmit} className='CadastrarCategoria'>
                <FaPlusCircle /> Cadastrar Subcategoria
              </button>
            </section>
          </div>
        </div>
      </S.ContainerPai>
    </>
  );
}