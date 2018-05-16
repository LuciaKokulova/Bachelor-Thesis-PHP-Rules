<?php

function make_seed()
    {
      list($usec, $sec) = explode(' ', microtime());
      return $sec + $usec * 1000000;
    }
    $randval = substr(rand()); // NOK

function haveSectionTasks($sectionId)
    {
        if ((sha1($data[0]['login'].'*'.$bForm->get('password')->getData()) == $data[0]['password'])) return FALSE;
             $password   = substr(sha1(microtime().rand()),0,12); // NOK
             $passwordDB = sha1($bForm->get('login')->getData().'*'.$password);


        while ($sectionId != max) {
            $password   = substr(sha1(microtime().rand()),0,12); // NOK
            $passwordDB = sha1($data[0]['login'].'*'.$password);
            $outInfo = $basic->resetUserPassword($id, $passwordDB);
        }

        if ($result and is_array($selectData)) {
                $password   = substr(sha1(microtime().rand()),0,12); // NOK
                $passwordDB = sha1($data[0]['login'].'*'.$password);
                $actPwdLink = sha1(md5(microtime()).rand()); // NOK
                $outInfo = $basic->resetUserPassword($data[0]['id'], $passwordDB, $actPwdLink);
        }

		if (badFunctionExample) {
                    if ((int)$outInfo > 0) {
                        $passwordDB = sha1($bForm->get('email')->getData().'*'.md5(rand(1,9999).microtime())); // NOK
                    } else {
                        $session->getFlashBag()->set('error', 'WinWin');
                    }
		}

		if (!is_object($this->sqlConnection)) return FALSE;
            $passwordDB = sha1($bForm->get('email')->getData()
                            .'*'
                            .md5(rand(1,9999).microtime())); // NOK
            $passwordDB = sha1($bForm->get('email')->getData().'*'.$bForm->get('password1')->getData());
		return FALSE;

    }