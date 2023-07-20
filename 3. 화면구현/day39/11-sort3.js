const tbody = document.querySelector('tbody')
const trArray = Array.from(document.querySelectorAll('tbody > tr'))

const titleAsc = document.getElementById('titleAsc')
const titleDesc = document.getElementById('titleDesc')
const priceAsc = document.getElementById('priceAsc')
const priceDesc = document.getElementById('priceDesc')
const titleBtn = document.getElementById('titleBtn')
const priceBtn = document.getElementById('priceBtn')

let tSort = titleBtn.classList
let pSort = priceBtn.classList

titleBtn.onclick = function() {
    if(tSort != 'asc') {
        titleAsc.click()
        titleBtn.querySelector('span').innerText = '↑'
        tSort.replace('desc', 'asc')
    }
    else {
        titleDesc.click()
        titleBtn.querySelector('span').innerText = '↓'
        tSort.replace('asc', 'desc')
    }
}

priceBtn.onclick = function() {
    if(pSort != 'asc') {
        priceAsc.click()
        priceBtn.querySelector('span').innerText = '↑'
        pSort.replace('desc', 'asc')
    }
    else {
        priceDesc.click()
        priceBtn.querySelector('span').innerText = '↓'
        pSort.replace('asc', 'desc')
    }
}

titleAsc.onclick = function() {
    trArray.sort((a, b) => {
        const ta = a.querySelector('.title').innerText
        const tb = b.querySelector('.title').innerText
        console.log(ta, tb)
        return ta > tb ? 1 : -1
    })
    trArray.forEach(tr => tbody.appendChild(tr))
}

titleDesc.onclick = function() {
    trArray.sort((a, b) => {
        const ta = a.querySelector('.title').innerText
        const tb = b.querySelector('.title').innerText
        console.log(ta, tb)
        return ta < tb ? 1 : -1
    })
    trArray.forEach(tr => tbody.appendChild(tr))
}

priceAsc.onclick = function() {
    trArray.sort((a, b) => {
        const ta = a.querySelector('.price').innerText.replaceAll(',', '').replace('원', '')
        const tb = b.querySelector('.price').innerText.replaceAll(',', '').replace('원', '')
        console.log(ta, tb)
        return ta - tb
    })
    trArray.forEach(tr => tbody.appendChild(tr))
}

priceDesc.onclick = function() {
    trArray.sort((a, b) => {
        const ta = a.querySelector('.price').innerText.replaceAll(',', '').replace('원', '')
        const tb = b.querySelector('.price').innerText.replaceAll(',', '').replace('원', '')
        console.log(ta, tb)
        return tb - ta
    })
    trArray.forEach(tr => tbody.appendChild(tr))
}
