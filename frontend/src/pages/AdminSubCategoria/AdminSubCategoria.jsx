import { FaSearch, FaArrowLeft } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import ImgLogo from '../../assets/images/ImgLogo.svg';
import * as S from './styles';
import { useState } from 'react';
import { subcategoriaService } from '../../services/subcategoria.service';
import { toast, ToastContainer } from 'react-toastify'; // Importe o toast
import 'react-toastify/dist/ReactToastify.css'; // Importe o CSS do toast

export function AdminSubCategoria() {
  const navigate = useNavigate();
  const [idSubcategoria, setIdSubcategoria] = useState('');
  const [codCategoria, setCodCategoria] = useState('');
  const [nomeSubCategoria, setNomeSubCategoria] = useState('');
  const [destaque, setDestaque] = useState(false);
  const [descricao, setDescricao] = useState('');
  const [ativa, setAtiva] = useState(false);

  async function atualizarSubcategoria(id) {
    if (!id || !nomeSubCategoria || !descricao || ativa === null) {
      toast.error('Preencha todos os campos!');
      return;
    }

    const subcategoriaAtualizada = {
      codCategoria: codCategoria,
      nome: nomeSubCategoria,
      destaque: destaque,
      descricao: descricao,
      ativa: ativa
    };

    try {
      await subcategoriaService.update(id, subcategoriaAtualizada);
      console.log(`Subcategoria com ID ${id} atualizada com sucesso!`);
      toast.success(`Subcategoria com ID ${id} atualizada com sucesso!`);
      // Lógica para atualizar a lista de subcategorias (se necessário)
    } catch (error) {
      console.error(`Erro ao atualizar subcategoria com ID ${id}:`, error);
      toast.error(`Erro ao atualizar subcategoria com ID ${id}:`, error);
    }
  }

  const novaSubcategoria = {
    codCategoria: codCategoria,
    nome: nomeSubCategoria,
    destaque: destaque,
    descricao: descricao,
    ativa: ativa
  };

  async function criarSubcategoria() {
    if (!novaSubcategoria || !descricao || ativa === null) {
      toast.error('Preencha todos os campos!');
      return;
    }

    try {
      await subcategoriaService.create(novaSubcategoria);
      toast.success('Subcategoria criada com sucesso!');

      setCodCategoria('');
      setNomeSubCategoria('');
      setDestaque(false);
      setDescricao('');
      setAtiva(false);

    } catch (error) {
      console.error('Erro ao criar subcategoria:', error);
      toast.error('Erro ao criar subcategoria.', error);
    }
  }

  async function deletarSubcategoriaPorId(id) {
    if (!id) {
      toast.error('Digite um ID para deletar!');
      return;
    }

    try {
      await subcategoriaService.deleteById(id);
      console.log(`Subcategoria com ID ${id} deletada com sucesso.`);
      toast.success(`Subcategoria com ID ${id} deletada com sucesso.`);
      // Lógica para atualizar a lista de subcategorias (se necessário)
    } catch (error) {
      console.error(`Erro ao deletar subcategoria com ID ${id}:`, error);
      toast.error(`Erro ao deletar subcategoria com ID ${id}:`, error);
    }
  }

  return (
    <>
      <S.ContainerPai>
      <ToastContainer className='toastContainer' />
        <div className='divDashBoard'>
          <img src={ImgLogo} />

          <h1>Nova Sub-Categoria</h1>

          <Link to={'/dashboardsubcategoria'} className='Link'><FaArrowLeft className='icons' />Voltar</Link>

        </div>

        <div className='divPrincipal'>
          <section className='section1'>
            <input placeholder='Pesquisar' className='InputPesquisar' />
            <FaSearch className="IconLupa" />


          </section>

          <div>
            <section className='section2'>
              <h1>Nova Sub-Categoria</h1>

              <label htmlFor="codigoCategoria">Código Categoria:</label>
              <input
                type="text"
                id="codigoCategoria"
                className='InputCodCategoria'
                value={codCategoria}
                onChange={e => setCodCategoria(e.target.value)}
                required
              />

              <label htmlFor="nome">Nome:</label>
              <input
                type="text"
                id="nome"
                className='InputNomeCat'
                value={nomeSubCategoria}
                onChange={e => setNomeSubCategoria(e.target.value)}
                required
              />

              <label htmlFor="destaque">Destaque:</label>
              <input
                type="checkbox"
                id="destaque"
                checked={destaque}
                onChange={e => setDestaque(e.target.checked)}
              />

              <label htmlFor="descricao">Descrição:</label>
              <textarea
                id="descricao"
                className='InputDescriCat'
                value={descricao}
                onChange={e => setDescricao(e.target.value)}
              />

              <label htmlFor="ativa">Ativa:</label>
              <input
                type="checkbox"
                id="ativa"
                checked={ativa}
                onChange={e => setAtiva(e.target.checked)}
              />

            </section>

            <section className='section3'>
              <input
                type='number'
                placeholder='ID da Subcategoria'
                value={idSubcategoria}
                onChange={e => setIdSubcategoria(e.target.value)}
              />

              <button type='button' onClick={() => deletarSubcategoriaPorId(idSubcategoria)}>
                Deletar por ID
              </button>
              <button type='button' onClick={() => atualizarSubcategoria(idSubcategoria)}>
                Atualizar por ID
              </button>

              <button type="button" className='CadastrarCategoria' onClick={criarSubcategoria}>Criar Sub-Categoria</button>

            </section>

          </div>
        </div>
      </S.ContainerPai>
    </>
  );
}