const data = [
    { name: 'Conan Gray', mail: 'adsf@adsf.com' },
    { name: 'Chiho Won', mail: 'a@b.com' },
    { name: 'Stan', mail: 'b@b.com' },
]

const mails = data.map(x => x.mail)
console.log(mails)

const name = data.map(x => x.name).filter(name => name.startsWith('C'))
console.log(name)