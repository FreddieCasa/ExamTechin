import { useState } from 'react';
import axios from 'axios';

const AddAd = () => {
    const [ad, setAd] = useState({
        title: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setAd({
            ...ad,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/adverts', ad)
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error("There was an error adding the ad!", error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title</label>
                <input type="text" name="title" value={ad.title} onChange={handleChange} required />
            </div>
            <div>
                <label>Description</label>
                <input type="text" name="description" value={ad.description} onChange={handleChange} required />
            </div>
            
            <button type="submit">Add Category</button>
        </form>
    );
};

export default AddAd;