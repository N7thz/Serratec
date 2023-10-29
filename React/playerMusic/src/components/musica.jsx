const Musica = ({musica}) => {

    return (
        <div className='w-full h-16 flex hover:bg-zinc-600 my-2  rounded-lg'>
            <img src={musica.capa} className='m-2 rounded-full ' alt={musica.nome}  />

            <section className='w-[95%] pl-2 flex flex-col justify-around'>
                <h1 className='text-zinc-50'>
                    {musica.artista}
                </h1>
                <h3 className='text-zinc-300 text-sm'>
                    {musica.nome}
                </h3>
            </section>
        </div>
    )
}

export default Musica