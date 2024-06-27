import { useState } from 'react';
import axios from 'axios';

const AddCategory = () => {
    const [category, setCategory] = useState({
        title: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCategory({
            ...category,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/categories', book)
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error("There was an error adding the category!", error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title</label>
                <input type="text" name="title" value={category.title} onChange={handleChange} required />
            </div>
            <button type="submit">Add Category</button>
        </form>
    );
};

export default AddCategory;