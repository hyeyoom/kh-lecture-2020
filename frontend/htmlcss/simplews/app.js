const express = require('express')
const app = express()
const port = 6600

app.use(express.static('../html'))

const bp = require('body-parser')
app.use(bp.json())
app.use(bp.urlencoded({extended: true}))

const loginHandler = (req, res) => {
    console.log(req.body)
    res.send('Hello Server')
};

app.post('/login', loginHandler);

app.listen(port, () => {
    console.log(`express app has been started on ${port}`)
});