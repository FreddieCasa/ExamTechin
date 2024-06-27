import { useEffect, useState } from 'react';
import axios from 'axios';

const AdList = () => {
    const [ads,setAds] = useState([]);
    const [editingAds, setEditingAds] = useState(null);

    useEffect(() => {
        fetchAds();
    }, []);

    const fetchAds = () => {
        axios.get('http://localhost:8080/adverts')
            .then(response => {
            setAds(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the ads!", error);
            });
    };

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/adverts/remove/${id}`)
            .then(response => {
                fetchAds();
            })
            .catch(error => {
                console.error("There was an error deleting the ad!", error);
            });
    };

    const handleEdit = (ad) => {
        setEditingAds(ad);
    };

    const handleUpdate = (e) => {
        e.preventDefault();
        axios.post(`http://localhost:8080/adverts/update/${editingAds.id}`, editingAds)
            .then(response => {
                fetchAds();
                setEditingAds(null);
            })
            .catch(error => {
                console.error("There was an error updating the ad!", error);
            });
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEditingAds({
            ...editingAds,
            [name]: value
        });
    };

    return (
        <div>
            <h1>Ad List</h1>
            <ul>
                {ads.map(ad => (
                    <li key={ad.id}>
                        {ad.title} - {ad.description}
                        <button onClick={() => handleDelete(ad.id)}>Delete</button>
                        <button onClick={() => handleEdit(ad)}>Update</button>
                    </li>
                ))}
            </ul>
            {editingAds && (
                <form onSubmit={handleUpdate}>
                    <div>
                        <label>Title</label>
                        <input type="text" name="title" value={editingAds.title} onChange={handleChange} required />
                    </div>
                    <div>
                        <label>Description</label>
                        <textarea name="description" value={editingAds.description} onChange={handleChange} required />
                    </div>
                    <button type="submit">Update ad</button>
                    <button onClick={() => setEditingAds(null)}>Cancel</button>
                </form>
            )}
        </div>
    );
};

export default AdList;