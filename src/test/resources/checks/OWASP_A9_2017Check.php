<?php

function getGroupsForSolutionist($userId, $organizationId)
    {
        if (!is_object($this->sqlConnection)) return FALSE;
                $password   = substr(sha1(microtime().rand()),0,12); // NOK
                $passwordDB = sha1($data[0]['login'].'*'.$password); // NOK
                $actPwdLink = sha1((microtime()).rand()); // NOK
                md5(microtime()).rand(); // NOK
                $outInfo = $basic->resetUserPassword($data[0]['id'], $passwordDB, $actPwdLink);
        return $st->fetchAll();
    }

function haveSectionTasks($sectionId)
    {
        if ((sha1($data[0]['login'].'*'.$bForm->get('password')->getData()) == $data[0]['password'])) return FALSE; // NOK

         $heslo = hash('md5', 'The quick brown fox jumped over the lazy dog.'); // NOK
         $heslo = hash('ripemd128', 'The quick brown fox jumped over the lazy dog.'); // NOK

        while ($sectionId != max) {
            $userId    = (int)$userData['user']['id'];
			$userLogin = $userData['user']['login'];
			$password  = sha1($userLogin.'*'.$pwd1); // NOK
        }

        if ($result and is_array($selectData)) {
            $password   = substr(sha1(microtime().rand()),0,12); // NOK
            $passwordDB = sha1($data[0]['login'].'*'.$password); // NOK
            $outInfo = $basic->resetUserPassword($id, $passwordDB);
		}

		if (badFunctionExample) {
                    $password   = substr(sha1(microtime().rand()),0,12); // NOK
                    $passwordDB = sha1($bForm->get('login')->getData().'*'.$password); // NOK
                    $outInfo = $basic->saveUser($bForm->get('name')->getData(), $bForm->get('surname')->getData(), $bForm->get('email')->getData(), $bForm->get('login')->getData(), $bForm->get('active')->getData(), $passwordDB, $bForm->get('solutionist')->getData());
                    if ((int)$outInfo > 0) {
                        $basic->addUserDepartment($outInfo, $bForm->get('departments_id')->getData(), rand(1));
                        $basic->sendPassword($bForm->get('email')->getData(), $bForm->get('login')->getData(), $password);
                        $session->getFlashBag()->set('success', 'Používateľ bol pridaný. Heslo bolo odoslané na E-mail '.$bForm->get('email')->getData().' ['.$password.'].');
                    } else {
                        $session->getFlashBag()->set('error', 'Používateľ nebol pridaný.');
                    }
		}

		if (!is_object($this->sqlConnection)) return FALSE;
            $passwordDB = sha1($bForm->get('email')->getData() // NOK
                            .'*'
                            .md5(rand(1,9999).microtime())); // NOK
            $passwordDB = sha1($bForm->get('email')->getData().'*'.$bForm->get('password1')->getData()); // NOK
		return FALSE;

    }