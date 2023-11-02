import { useState } from 'react'
import styled from 'styled-components';
import { HiMiniBars3CenterLeft } from "react-icons/hi2";
import Modal from './Modal';

const StyledButton = styled.button`
    
    width: 50px;
    height: 50px;
    margin: 20px;
    border: 2px solid #444;
    border-radius: 50%;
    cursor: pointer;

    .img {
        transform: scale(2);
    }
`

const BtnMenu = () => {

    const [openModal, setOpenModal] = useState(false) 

    return (
        <>
            <StyledButton onClick={() => {setOpenModal(true)}}>
                <HiMiniBars3CenterLeft className='img' />
            </StyledButton>

            <Modal isOpen={openModal} setOpenModal={() => setOpenModal(!openModal)}>
                <p>
                    Lorem ipsum, dolor sit amet consectetur adipisicing elit. Odit ipsum exercitationem praesentium! Dignissimos possimus ex facilis recusandae, laudantium et culpa vero voluptatum aliquam ducimus aspernatur quidem exercitationem dicta quibusdam quaerat.
                </p>
            </Modal>
        </>
    )
}

export default BtnMenu