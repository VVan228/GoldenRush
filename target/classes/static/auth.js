
export {getTokenData};

function getTokenData(email, password) {
    console.log("get token data");
    return fetch('http://192.168.0.100:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            email: email,
            password: password,
        }),
    })
        .then((res) => {
            if (res.status === 200) {
                saveTokenData(res.json());
                return Promise.resolve();
            }
            return Promise.reject();
        });
}



function saveTokenData(token) {
    let expTime = parseJwt(token.access_token);
    localStorage.setItem("expTime", JSON.stringify(expTime));
    localStorage.setItem("tokenData", JSON.stringify(token));
}

function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}


function refreshToken(token) {
    return fetch('http://192.168.0.100:8080/auth/updateAccessToken', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            refresh_token: token,
        }),
    })
        .then((res) => {
            if (res.status === 200) {
                saveTokenData(res.json()); // сохраняем полученный обновленный токен в sessionStorage, с помощью функции, заданной ранее
                return Promise.resolve();
            }
            return Promise.reject();
        });
}


export async function fetchWithAuth(url, options) {

    const loginUrl = 'http://192.168.0.100:8080/auth/login';
    let tokenData = null;

    if (localStorage.tokenData) {
        tokenData = JSON.parse(localStorage.tokenData);
    } else {
        return window.location.replace(loginUrl);
    }

    if (!options.headers) {
        options.headers = {};
    }

    if (tokenData) {
        if (Date.now() >= localStorage.expTime) {
            try {
                // const newToken =
                await refreshToken(tokenData.refresh_token);
                // saveTokenData(newToken);
            } catch (e) {
                return  window.location.replace(loginUrl);
            }
        }

        options.headers.Authorization = `${tokenData.access_token}`;
    }

    return fetch(url, options);
}


// var res = parseJwt("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYUBiYi5ydSIsInJvbGUiOiJTVVBFUlZJU09SIiwidXNlcklkIjoxLCJpYXQiOjE2NjU4MzI1NTYsImV4cCI6MTY2NjQzNzM1Nn0.gJibU4PHCfO1nF04PkDzKPwPXSKyQftA0n75Yc2fUrc0");
// console.log(res);
//
//
// var email = "aa@bb.ru";
// var password = "admin";